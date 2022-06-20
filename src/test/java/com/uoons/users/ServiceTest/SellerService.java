package com.uoons.users.ServiceTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uoons.users.enitity.*;
import com.uoons.users.repository.*;
import com.uoons.users.serviceImpl.SellerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SellerService {

    @InjectMocks
    private SellerServiceImpl sellerService;
    @Mock
    PickupAddressRepository pickupAddressRepository;
    @Mock
    UserRepository userRepository;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @Mock
    RoleRepository roleRepository;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    BankDetails bankDetails;
    @Mock
    BankDetailsRepository bankDetailsRepository;
    @Mock
    BusinessDetailsRepository businessDetailsRepository;

    @Test
    public void saveSeller() {
        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(2L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Mockito.when(passwordEncoder.encode(entity.getPassword())).thenReturn("shas");
//        Mockito.when(roleRepository.findByRoleName("SELLER")).thenReturn(role);
        Mockito.when(userRepository.save(entity)).thenReturn(entity);
        UserEntity returned = this.sellerService.saveSeller(entity);
        assertEquals(returned, entity);
    }

    @Test
    public void updateSeller() {
        RoleEntity role = new RoleEntity(1L, "CUSTOMER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().id(2L).firstName("kartik").lastName("khantal").id(2L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();

        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);

        Mockito.when(passwordEncoder.encode(entity.getPassword())).thenReturn("shas");
        Mockito.when(userRepository.findById(2L)).thenReturn(optional);
        Mockito.when(sellerService.updateSeller(entity.getId(), entity)).thenReturn(entity);
        UserEntity returned = this.sellerService.updateSeller(entity.getId(), entity);
        assertEquals(returned, entity);
    }

    @Test
    public void saveBusinessDetails() {
        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(7L).gstNumber("hnapk123")
                .panNumber("abc123").build();

        RoleEntity role = new RoleEntity(2L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(3L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Mockito.when(userRepository.findById(entity.getId())).thenReturn(optional);
        Mockito.when(businessDetailsRepository.save(businessDetails)).thenReturn(businessDetails);
        BusinessDetails returned = this.sellerService.saveBusinessDetails(businessDetails, entity.getId());
        assertEquals(businessDetails, returned);
    }

    @Test
    public void getBusinessDetails() {
        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(7L).gstNumber("hnapk123")
                .panNumber("abc123").build();

        RoleEntity role = new RoleEntity(2L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(3L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Mockito.when(userRepository.findById(entity.getId())).thenReturn(optional);
        Mockito.when(businessDetailsRepository.findBySellerId(entity.getId())).thenReturn(businessDetails);
        BusinessDetails returned = this.sellerService.getBusinessDetail(entity.getId());
        assertEquals(businessDetails, returned);
    }

    @Test
    public void updateBusinessDetails() {
        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(7L).gstNumber("hnapk123")
                .panNumber("abc123").build();

        RoleEntity role = new RoleEntity(2L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(3L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Mockito.when(userRepository.findById(entity.getId())).thenReturn(optional);
        Mockito.when(businessDetailsRepository.findBySellerId(entity.getId())).thenReturn(businessDetails);
        Mockito.when(businessDetailsRepository.save(businessDetails)).thenReturn(businessDetails);
        BusinessDetails returned = this.sellerService.updateBusinessDetail(entity.getId(), businessDetails);
        assertEquals(businessDetails, returned);
    }
    @Test
    public void saveBankDetails() {
        BankDetails bankDetails=BankDetails.builder().sellerId(5L).bankDetailsId(7L).bankName("SBI").
                bankHolderName("KKARTIK").ifscCode("SBIN007732").accountNumber("zbc1234de").build();
        RoleEntity role = new RoleEntity(2L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(3L)
                .email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Mockito.when(userRepository.findById(entity.getId())).thenReturn(optional);
        Mockito.when(bankDetailsRepository.save(bankDetails)).thenReturn(bankDetails);
        BankDetails returned = this.sellerService.saveBankDetails(bankDetails,entity.getId());
        assertEquals(bankDetails, returned);
    }
    @Test
    public void getBankDetails() {
        BankDetails bankDetails=BankDetails.builder().sellerId(5L).bankDetailsId(7L).bankName("SBI").
                bankHolderName("KKARTIK").ifscCode("SBIN007732").accountNumber("zbc1234de").build();
        RoleEntity role = new RoleEntity(2L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(3L)
                .email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Mockito.when(userRepository.findById(entity.getId())).thenReturn(optional);
        Mockito.when(bankDetailsRepository.findBySellerId(entity.getId())).thenReturn(bankDetails);
        BankDetails returned = this.sellerService.getBankDetails(entity.getId());
        assertEquals(bankDetails, returned);
    }
    @Test
    public void updateBankDetails() {
        BankDetails bankDetails=BankDetails.builder().sellerId(5L).bankDetailsId(7L).bankName("SBI").
                bankHolderName("KKARTIK").ifscCode("SBIN007732").accountNumber("zbc1234de").build();
        RoleEntity role = new RoleEntity(2L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(3L)
                .email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Mockito.when(userRepository.findById(entity.getId())).thenReturn(optional);
        Mockito.when(bankDetailsRepository.findBySellerId(entity.getId())).thenReturn(bankDetails);
        Mockito.when(bankDetailsRepository.save(bankDetails)).thenReturn(bankDetails);
        BankDetails returned = this.sellerService.updateBankDetails(entity.getId(),bankDetails);
        assertEquals(bankDetails, returned);
    }
    @Test
    public void savePickupAddress() {
        PickupAddress pickupAddress=PickupAddress.builder().pickupaddressId(4L).addressLine("punasa").pincode("487551").
                landmark("C21").city("Indore").alternateMobileNo("987654322").area("VIjay nagar").state("MP").build();
        RoleEntity role = new RoleEntity(2L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(3L)
                .email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Mockito.when(userRepository.findById(entity.getId())).thenReturn(optional);
        Mockito.when(pickupAddressRepository.save(pickupAddress)).thenReturn(pickupAddress);
        PickupAddress returned = this.sellerService.savePickupAddress(pickupAddress,entity.getId());
        assertEquals(pickupAddress, returned);
    }
    @Test
    public void getPickupAddress() {
        PickupAddress pickupAddress=PickupAddress.builder().pickupaddressId(4L).addressLine("punasa").pincode("487551").
                landmark("C21").city("Indore").alternateMobileNo("987654322").area("VIjay nagar").state("MP").build();
        RoleEntity role = new RoleEntity(2L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(3L)
                .email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Mockito.when(userRepository.findById(entity.getId())).thenReturn(optional);
        Mockito.when(pickupAddressRepository.findBySellerId(entity.getId())).thenReturn(pickupAddress);
//        Mockito.when(pickupAddressRepository.save(pickupAddress)).thenReturn(pickupAddress);
        PickupAddress returned = this.sellerService.getPickupAddress(entity.getId());
        assertEquals(pickupAddress, returned);
    }
    @Test
    public void updatePickupAddress() {
        PickupAddress pickupAddress=PickupAddress.builder().pickupaddressId(4L).addressLine("punasa").pincode("487551").
                landmark("C21").city("Indore").alternateMobileNo("987654322").area("VIjay nagar").state("MP").build();
        RoleEntity role = new RoleEntity(2L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(3L)
                .email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Mockito.when(userRepository.findById(entity.getId())).thenReturn(optional);
        Mockito.when(pickupAddressRepository.findBySellerId(entity.getId())).thenReturn(pickupAddress);
        Mockito.when(pickupAddressRepository.save(pickupAddress)).thenReturn(pickupAddress);
        PickupAddress returned = this.sellerService.updatePickupAddress(entity.getId(),pickupAddress);
        assertEquals(pickupAddress, returned);
    }

}
