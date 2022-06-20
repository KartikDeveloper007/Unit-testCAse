package com.uoons.users.serviceImpl;

import com.uoons.users.enitity.*;
import com.uoons.users.exception.EmptyInput;
import com.uoons.users.exception.NotFound;
import com.uoons.users.repository.*;
import com.uoons.users.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;

    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    @Autowired
    private PickupAddressRepository pickupAddressRepository;

    @Value("${role.name.seller}")
    private String sellerRole;

    @Override
    public UserEntity saveSeller(UserEntity seller) {
        if (!seller.getEmail().isEmpty() && !seller.getPassword().isEmpty()) {
            seller.setPassword(passwordEncoder.encode(seller.getPassword()));
            seller.setCreatedBy(seller.getEmail());
            seller.setCreatedDate(new Date());
            seller.setIsActive(Boolean.TRUE);
            seller.setIsDeleted(Boolean.FALSE);

            RoleEntity roleSeller = roleRepository.findByRoleName(sellerRole);
            seller.addRole(roleSeller);
            return userRepository.save(seller);
        } else {

            throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "emailId and Password can not be Empty !");
        }
    }

    @Override
    public UserEntity updateSeller(Long id, UserEntity userEntity) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity updateSeller = optionalUser.get();
            if (!userEntity.getEmail().isEmpty() && !userEntity.getPassword().isEmpty()) {
                updateSeller.setEmail(userEntity.getEmail());
                updateSeller.setPassword(passwordEncoder.encode(userEntity.getPassword()));
                updateSeller.setFirstName(userEntity.getFirstName());
                updateSeller.setLastName(userEntity.getLastName());
                updateSeller.setMobileNo(userEntity.getMobileNo());

                updateSeller.setUpdatedBy(userEntity.getEmail());
                updateSeller.setUpdateDate(new Date());
                return userRepository.save(updateSeller);

            }
            else {
                throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "email id or password is empty !");
            }

        }
        else
        {
            throw new NotFound(HttpStatus.NOT_FOUND.value(), "please enter the valid id !!");
        }

    }

    @Override
    public BusinessDetails saveBusinessDetails(BusinessDetails businessDetails, Long id) {
        Optional<UserEntity> optionalUser=userRepository.findById(id);

        if(optionalUser.isPresent()){
            UserEntity userEntity=optionalUser.get();
            if(!businessDetails.getPanNumber().isEmpty() && !businessDetails.getGstNumber().isEmpty()){
                businessDetails.setSellerId(userEntity.getId());
                businessDetails.setCreatedBy(userEntity.getEmail());
                businessDetails.setCreatedDate(new Date());
                return businessDetailsRepository.save(businessDetails);
            }else{
                throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "Pan number  and Gst number should not be null!");
            }
        }else{
            throw new NotFound(HttpStatus.BAD_REQUEST.value(), "Invalid EmailId !");
        }
    }

    @Override
    public BusinessDetails getBusinessDetail(Long id) {
      UserEntity user =userRepository.findById(id).get();

        BusinessDetails businessDetails =businessDetailsRepository.findBySellerId(user.getId());
        if (businessDetails==null) {
            throw new NotFound(HttpStatus.NO_CONTENT.value(), "Invalid Id");
        } else {
            return businessDetails;
        }
    }

    @Override
    public BusinessDetails updateBusinessDetail(Long id, BusinessDetails businessDetails) {
        Optional<UserEntity> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()) {
            UserEntity user=optionalUser.get();
            if(!businessDetails.getPanNumber().isEmpty() && !businessDetails.getGstNumber().isEmpty()) {
                BusinessDetails updateBusiness = businessDetailsRepository.findBySellerId(user.getId());
                updateBusiness.setPanNumber(businessDetails.getPanNumber());
                updateBusiness.setGstNumber(businessDetails.getGstNumber());
                updateBusiness.setUpdatedBy(user.getEmail());
                updateBusiness.setUpdateDate(new Date());
                return businessDetailsRepository.save(updateBusiness);
            }else {
                 throw new EmptyInput(HttpStatus.NO_CONTENT.value(), "pan number and gst number should not be null");
            }
        }else {

            throw new NotFound(HttpStatus.BAD_REQUEST.value(), "Invalid id !");
        }
    }


    @Override
    public BankDetails saveBankDetails(BankDetails bankDetails, Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            UserEntity userEntity=optionalUser.get();
            if(!bankDetails.getAccountNumber().isEmpty() && !bankDetails.getIfscCode().isEmpty()) {
                bankDetails.setSellerId(userEntity.getId());
                bankDetails.setCreatedBy(userEntity.getEmail());
                bankDetails.setCreatedDate(new Date());
                return bankDetailsRepository.save(bankDetails);
            }else {
                throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "Account Number and ifsc code should not be null");
            }
        }else {
            throw new NotFound(HttpStatus.BAD_REQUEST.value(), "Invalid Id !");
        }
    }


    @Override
    public BankDetails getBankDetails(Long id) {
        UserEntity user =userRepository.findById(id).get();

        BankDetails bankDetails =bankDetailsRepository.findBySellerId(user.getId());
        if (bankDetails==null) {
            throw new NotFound(HttpStatus.NO_CONTENT.value(), "Invalid emailId");
        }else {
           return bankDetails;
        }
    }

    @Override
    public BankDetails updateBankDetails(Long id, BankDetails bankDetails) {
        Optional<UserEntity> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()) {
            UserEntity user=optionalUser.get();
            if (!bankDetails.getAccountNumber().isEmpty() && !bankDetails.getIfscCode().isEmpty()) {
                BankDetails updateBankDetail = bankDetailsRepository.findBySellerId(user.getId());
                updateBankDetail.setBankName(bankDetails.getBankName());
                updateBankDetail.setBankHolderName(bankDetails.getBankHolderName());
                updateBankDetail.setAccountNumber(bankDetails.getAccountNumber());
                updateBankDetail.setIfscCode(bankDetails.getIfscCode());
                updateBankDetail.setUpdatedBy(user.getEmail());
                updateBankDetail.setUpdateDate(new Date());
                return bankDetailsRepository.save(updateBankDetail);
            }else {
                throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "Account number and Ifsc code should not be null !");
            }
        }else {
            throw new NotFound(HttpStatus.BAD_REQUEST.value(), "ivalid id !!");
        }
    }


   @Override
    public PickupAddress savePickupAddress(PickupAddress pickupAddress, Long id) {
        Optional<UserEntity> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()) {
            UserEntity userEntity=optionalUser.get();
            if (!pickupAddress.getPincode().isEmpty() && !pickupAddress.getState().isEmpty() && !pickupAddress.getCity().isEmpty()) {
                pickupAddress.setSellerId(userEntity.getId());
                pickupAddress.setCreatedBy(userEntity.getEmail());
                pickupAddress.setCreatedDate(new Date());
                return pickupAddressRepository.save(pickupAddress);
            }else {
                throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "Pickup Address should not be null !");
            }
        }else {
              throw new NotFound(HttpStatus.NOT_FOUND.value(), "Please enter the valid id !!");
        }
    }

    @Override
    public PickupAddress getPickupAddress(Long id) {
        UserEntity user =userRepository.findById(id).get();

        PickupAddress pickupAddress =pickupAddressRepository.findBySellerId(user.getId());
        if (pickupAddress==null) {
            throw new NotFound(HttpStatus.NO_CONTENT.value(), "Invalid emailId");
        }else {
            return pickupAddress;
        }
    }

    @Override
    public PickupAddress updatePickupAddress(Long id, PickupAddress pickupAddress) {
        Optional<UserEntity> optionalUser= userRepository.findById(id);
        System.out.println(pickupAddress.toString());
        if(optionalUser.isPresent()) {
            UserEntity user=optionalUser.get();

            if(!pickupAddress.getPincode().isEmpty()) {
                PickupAddress updatePickupAddress = pickupAddressRepository.findBySellerId(user.getId());
                updatePickupAddress.setAddressLine(pickupAddress.getAddressLine());
                updatePickupAddress.setLandmark(pickupAddress.getLandmark());
                updatePickupAddress.setArea(pickupAddress.getArea());

                updatePickupAddress.setCity(pickupAddress.getCity());
                updatePickupAddress.setState(pickupAddress.getState());
                updatePickupAddress.setPincode(pickupAddress.getPincode());
                updatePickupAddress.setAlternateMobileNo(pickupAddress.getAlternateMobileNo());
                updatePickupAddress.setUpdatedBy(user.getEmail());
                updatePickupAddress.setUpdateDate(new Date());
                return pickupAddressRepository.save(updatePickupAddress);
            }else {
                throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "Pickup address should not be null !!");
            }
        }else {
            throw new NotFound(HttpStatus.NOT_FOUND.value(), "please enter the valid id!!");
        }
    }

}
