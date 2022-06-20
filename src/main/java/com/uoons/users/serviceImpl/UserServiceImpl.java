package com.uoons.users.serviceImpl;

import com.uoons.users.dto.AddressType;
import com.uoons.users.enitity.AddressEntity;
import com.uoons.users.enitity.RoleEntity;
import com.uoons.users.enitity.UserEntity;
import com.uoons.users.exception.AddressTypeExistException;
import com.uoons.users.exception.EmptyInput;
import com.uoons.users.exception.NotFound;
import com.uoons.users.repository.AddressRepository;
import com.uoons.users.repository.RoleRepository;
import com.uoons.users.repository.UserRepository;
import com.uoons.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Value("${role.name.customer}")
    private String customerRole;

    List<RoleEntity> roles = new ArrayList<>();

    @Override
    public UserEntity saveCustomer(@Valid UserEntity customer)  {

        if (!customer.getEmail().isEmpty() && !customer.getPassword().isEmpty()) {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customer.setCreatedBy(customer.getEmail());
            customer.setCreatedDate(new Date());
            customer.setIsActive(Boolean.TRUE);
            customer.setIsDeleted(Boolean.FALSE);
            RoleEntity roleCustomer = roleRepository.findByRoleName(customerRole);
            customer.addRole(roleCustomer);
            return userRepository.save(customer);

        } else {

            throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "email id or password can not be empty");
        }

    }


    @Override
    public UserEntity updateCustsomer(UserEntity userEntity, Long id) {

        Optional<UserEntity> optionalUser= userRepository.findById(id);
        if (optionalUser.isPresent())
        {
            UserEntity updateUser=optionalUser.get();
            if(!userEntity.getEmail().isEmpty() && !userEntity.getPassword().isEmpty()) {
                updateUser.setFirstName(userEntity.getFirstName());
                updateUser.setEmail(userEntity.getEmail());
                updateUser.setPassword(passwordEncoder.encode(userEntity.getPassword()));
                updateUser.setLastName(userEntity.getLastName());
                updateUser.setMobileNo(userEntity.getMobileNo());
                updateUser.setUpdatedBy(userEntity.getEmail());
                updateUser.setUpdateDate(new Date());
                return userRepository.save(updateUser);
            }else {
                throw new EmptyInput(HttpStatus.BAD_REQUEST.value(), "email id or password can not be empty !");
            }
        } else {
            throw new NotFound(HttpStatus.BAD_REQUEST.value(), "please enter the correct user id");
        }

    }



    @Override
    public AddressEntity saveAddress(AddressEntity address, Long userid, AddressType addressType)  {
        UserEntity user=userRepository.findById(userid).get();
       List<AddressEntity> addressEntities =addressRepository.findByUserId(userid);
       Long count= addressEntities.stream().map(AddressEntity::getAddressId).count();

        if(count>=1){
            address.setPrimaryAddress(false);
        }
        String addressType1= addressType.getAddressType();

        Optional<AddressEntity> optionalAddressEntity = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,addressType1));


        if(optionalAddressEntity.isEmpty()) {
            address.setAddressType(addressType1);
            address.setUserId(user.getId());
            address.setCreatedDate(new Date());
            address.setCreatedBy(user.getEmail());
        }else{
            throw new AddressTypeExistException(HttpStatus.BAD_REQUEST.value(), "Address type exists");
        }

        return addressRepository.save(address);
    }

    @Override
    public AddressEntity updateAddress(AddressEntity address, Long userid) {
        UserEntity user=userRepository.findById(userid).get();

        AddressEntity addressEntity =addressRepository.findById(address.getAddressId()).get();
        addressEntity.setAlternateMobileNo(address.getAlternateMobileNo());
        addressEntity.setArea(address.getArea());
        addressEntity.setCity(address.getCity());
        addressEntity.setHosueNo(address.getHosueNo());
        addressEntity.setLandmark(address.getLandmark());
        addressEntity.setPincode(address.getPincode());
        addressEntity.setUpdateDate(new Date());
        addressEntity.setUpdatedBy(user.getEmail());
        return addressRepository.save(addressEntity);
    }

    public List<AddressEntity> getAddresses(Long userid){
        return addressRepository.findByUserId(userid);
    }

    @Override
    public String isPrimaryAddress(Long userid, AddressType addressType) {
        String primaryaddress= addressType.getAddressType();

        if(Objects.equals(primaryaddress, "OFFICE")) {
            Optional<AddressEntity> officeAddressOptional = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,primaryaddress));

            if(officeAddressOptional.isPresent()){
              AddressEntity officeAddress = addressRepository.findByUserIdAndAddressType(userid,primaryaddress);
              officeAddress.setPrimaryAddress(true);
              addressRepository.save(officeAddress);
           }



           Optional<AddressEntity> homeaddress = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,"HOME"));
          if(homeaddress.isPresent()){
               AddressEntity address=addressRepository.findByUserIdAndAddressType(userid,"HOME");
               address.setPrimaryAddress(false);
               addressRepository.save(address);
           }

            Optional<AddressEntity> officeaddressoptional = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,"OTHER"));
            if(officeaddressoptional.isPresent()){
                AddressEntity address=addressRepository.findByUserIdAndAddressType(userid,"OTHER");
                address.setPrimaryAddress(false);
                addressRepository.save(address);
            }



        }

        if(Objects.equals(primaryaddress, "HOME")) {
            Optional<AddressEntity> homeAddressOptional = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,primaryaddress));

            if(homeAddressOptional.isPresent()){
                AddressEntity homeAddress = addressRepository.findByUserIdAndAddressType(userid,primaryaddress);
                homeAddress.setPrimaryAddress(true);
                addressRepository.save(homeAddress);
            }

            Optional<AddressEntity> officeaddress = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,"OFFICE"));
            if(officeaddress.isPresent()){
                AddressEntity address=addressRepository.findByUserIdAndAddressType(userid,"OFFICE");
                address.setPrimaryAddress(false);
                addressRepository.save(address);
            }

            Optional<AddressEntity> otheraddressoptional = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,"OTHER"));
            if(otheraddressoptional.isPresent()){
                AddressEntity address=addressRepository.findByUserIdAndAddressType(userid,"OTHER");
                address.setPrimaryAddress(false);
                addressRepository.save(address);
            }

        }

        if(Objects.equals(primaryaddress, "OTHER")) {
            Optional<AddressEntity> otherAddressOptional = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,primaryaddress));

            if(otherAddressOptional.isPresent()){
                AddressEntity otherAddress = addressRepository.findByUserIdAndAddressType(userid,primaryaddress);
                otherAddress.setPrimaryAddress(true);
                addressRepository.save(otherAddress);
            }

            Optional<AddressEntity> officeaddress = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,"OFFICE"));
            if(officeaddress.isPresent()){
                AddressEntity address=addressRepository.findByUserIdAndAddressType(userid,"OFFICE");
                address.setPrimaryAddress(false);
                addressRepository.save(address);
            }

            Optional<AddressEntity> homeaddressoptional = Optional.ofNullable(addressRepository.findByUserIdAndAddressType(userid,"HOME"));
            if(homeaddressoptional.isPresent()){
                AddressEntity address=addressRepository.findByUserIdAndAddressType(userid,"HOME");
                address.setPrimaryAddress(false);
                addressRepository.save(address);
            }
        }

        return "Primary Address set";
    }

    @Override
    public UserEntity getById(Long id) {
        Optional<UserEntity> optionalUser= userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity user=optionalUser.get();
            return user;
        } else {
            throw new NotFound(HttpStatus.NO_CONTENT.value(), "email does not exist");
        }

    }

}
