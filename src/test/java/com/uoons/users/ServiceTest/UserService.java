package com.uoons.users.ServiceTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uoons.users.dto.AddressType;
import com.uoons.users.enitity.AddressEntity;
import com.uoons.users.enitity.RoleEntity;
import com.uoons.users.enitity.UserEntity;
import com.uoons.users.repository.AddressRepository;
import com.uoons.users.repository.RoleRepository;
import com.uoons.users.repository.UserRepository;
import com.uoons.users.serviceImpl.UserServiceImpl;
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
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserService {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private AddressRepository addressRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void saveCustomer() {
        RoleEntity role = new RoleEntity(1L, "CUSTOMER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().firstName("kartik").lastName("khantal").id(2L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        entity.addRole(role);
        Mockito.when(passwordEncoder.encode(entity.getPassword())).thenReturn("shas");

        Mockito.when(userRepository.save(entity)).thenReturn(entity);
        UserEntity returned = this.userService.saveCustomer(entity);
        assertEquals(returned, entity);
    }

    @Test
    public void updateCustomer() {
        RoleEntity role = new RoleEntity(1L, "CUSTOMER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().id(2L).firstName("kartik").lastName("khantal").id(2L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();

        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);

        Mockito.when(passwordEncoder.encode(entity.getPassword())).thenReturn("shas");
        Mockito.when(userRepository.findById(2L)).thenReturn(optional);
        Mockito.when(userService.updateCustsomer(entity, entity.getId())).thenReturn(entity);
        UserEntity returned = this.userService.updateCustsomer(entity, entity.getId());
        assertEquals(returned, entity);
    }

    @Test
    public void saveAddress() {
        RoleEntity role = new RoleEntity(1L, "CUSTOMER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().id(2L).firstName("kartik").lastName("khantal").id(2L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        AddressEntity address = AddressEntity.builder().userId(22L).addressId(2L).addressType("HOME").state("mp").pincode("487551").landmark("acc").area("viajy nagar").hosueNo("123").city("Indore").build();
        entity.addRole(role);
        List<AddressEntity> addressEntities = List.of(address);
        Optional<UserEntity> optional = Optional.of(entity);
//        Mockito.when(passwordEncoder.encode(entity.getPassword())).thenReturn("shas");
        Mockito.when(userRepository.findById(2L)).thenReturn(optional);
        Mockito.when(addressRepository.save(address)).thenReturn(address);
        addressEntities = addressRepository.findByUserId(entity.getId());
        AddressEntity returned = this.userService.saveAddress(address, entity.getId(), AddressType.OFFICE);
        assertEquals(returned, address);

    }

    @Test
    public void updateAddress() {
        RoleEntity role = new RoleEntity(1L, "CUSTOMER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().id(2L).firstName("kartik").lastName("khantal").id(2L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        AddressEntity address = AddressEntity.builder().userId(2L).addressId(2L).addressType("HOME").state("mp").pincode("487551").landmark("acc").area("viajy nagar").hosueNo("123").city("Indore").build();
        entity.addRole(role);
        Optional<UserEntity> optional = Optional.of(entity);
        Optional<AddressEntity> optional1 = Optional.of(address);
        Mockito.when(userRepository.findById(2L)).thenReturn(optional);
        Mockito.when(addressRepository.save(address)).thenReturn(address);
        Mockito.when(addressRepository.findById(address.getAddressId())).thenReturn(optional1);
        AddressEntity returned = this.userService.updateAddress(address, address.getUserId());
        assertEquals(address, returned);

    }

    @Test
    public void getAddresses() {
        RoleEntity role = new RoleEntity(1L, "CUSTOMER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().id(2L).firstName("kartik").lastName("khantal").id(2L).email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        AddressEntity address = AddressEntity.builder().userId(2L).addressId(2L).addressType("HOME").state("mp").pincode("487551").landmark("acc").area("viajy nagar").hosueNo("123").city("Indore").build();
        entity.addRole(role);
        List<AddressEntity> addressEntities = List.of(address);
        Optional<UserEntity> optional = Optional.of(entity);
//        Mockito.when(userRepository.findById(2L)).thenReturn(optional);
//        Mockito.when(addressRepository.save(address)).thenReturn(address);
//        Mockito.when(addressRepository.findById(address.getAddressId())).thenReturn(optional1);
        Mockito.when(addressRepository.findByUserId(address.getUserId())).thenReturn(addressEntities);
        List<AddressEntity> addresses = this.userService.getAddresses(address.getUserId());
        assertEquals(addressEntities, addresses);

    }

    @Test
    public void isPrimaryAddress() {
        RoleEntity role = new RoleEntity(1L, "CUSTOMER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);
        UserEntity entity = UserEntity.builder().id(2L).firstName("kartik").lastName("khantal").id(2L).
                email("kartikkhantal@gmail.com").password("1234").mobileNo("8878767877").role(roleEntities).build();
        AddressEntity address = AddressEntity.builder().userId(2L).addressId(3L).addressType("OFFICE")
                .state("mp").pincode("487551").landmark("acc").area("viajy nagar").hosueNo("123").city("Indore").build();
        entity.addRole(role);
        List<AddressEntity> addressEntities = List.of(address);
        Optional<UserEntity> optional = Optional.of(entity);

        Mockito.when(addressRepository.findByUserIdAndAddressType(address.getUserId(), address.getAddressType())).thenReturn(address);
        Mockito.when(addressRepository.save(address)).thenReturn(address);
        String addresses = this.userService.isPrimaryAddress(address.getUserId(),AddressType.OFFICE);
        assertEquals("Primary Address set", addresses);
    }


//    @Test
//    public void ShouldThrowException_SaveUser() {
//
//        RoleEntity role = new RoleEntity(1L, "Customer");
//        Set<RoleEntity> roleEntities = new HashSet<>();
//        roleEntities.add(role);
//
//        UserEntity entity = UserEntity.builder().userId("abc12").firstName("kartik").lastName("khantal").email("").password("").mobileNo("8878767877").role(roleEntities).build();
//
//        EmptyInput exception = assertThrows(EmptyInput.class, () ->
//                userService.saveCustomer(entity));
//        Assertions.assertThat(exception instanceof EmptyInput);
//        assertEquals("email id or password can not be empty !!", exception.getErrorMessage());
//    }
//
//    @Test
//    public void updatePatientRecord_nullId() throws Exception {
//        RoleEntity role = new RoleEntity(1L, "Customer");
//        Set<RoleEntity> roleEntities = new HashSet<>();
//        roleEntities.add(role);
//        UserEntity updatedRecord = UserEntity.builder().id(2L).userId("abc12").firstName("kartik").lastName("khantal").email("").password("").mobileNo("8878767877").role(roleEntities).build();
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/patient")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(updatedRecord));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isBadRequest())
//                .andExpect(result ->
//                        assertTrue(result.getResolvedException() instanceof NotFound))
//                .andExpect(result ->
//                        assertEquals("PatientRecord or ID must not be null!", result.getResolvedException().getMessage()));
//    }
//    @Test
//    public void UpdateUser() {
//        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
//        List<AddressEntity> addressEntities = new ArrayList<>();
//        addressEntities.add(address);
//
//        RoleEntity role = new RoleEntity(1L, "Customer");
//        Set<RoleEntity> roleEntities = new HashSet<>();
//        roleEntities.add(role);
//
//        UserEntity entity = UserEntity.builder().id(2L).userId("abc12").firstName("kartik").lastName("khantal").email("").password("").mobileNo("8878767877").address(null).role(roleEntities).build();
//
//        NotFound exception = assertThrows(NotFound.class, () ->
//                userService.updateCustsomer(entity, entity.getId()));
//
//        Assertions.assertThat(exception instanceof NotFound);
//        assertEquals("email id or password can not be empty !!", exception.getErrorMessage());
//    }
}

