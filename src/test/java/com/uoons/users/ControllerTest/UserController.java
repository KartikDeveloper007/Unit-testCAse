package com.uoons.users.ControllerTest;

import com.uoons.users.dto.AddressType;
import com.uoons.users.enitity.AddressEntity;
import com.uoons.users.enitity.RoleEntity;
import com.uoons.users.enitity.UserEntity;
import com.uoons.users.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserController {

    @InjectMocks
    private com.uoons.users.controller.UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void saveCustomer() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("21312").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "Customer");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

       // UserEntity entity = UserEntity.builder().userId("abc12").email("kartikkhantal@gmail.com").firstName("kartik").lastName("khantal").mobileNo("8878767877").password("abc123").address(addressEntities).role(roleEntities).build();

//        Mockito.when(userService.saveCustomer(entity)).thenReturn(entity);
//        ResponseEntity<?> returned = this.userController.saveCustomer(entity);
//        assertEquals(entity, returned.getBody());
    }

    /*@Test
    public void updateCustomer() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "Customer");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        UserEntity entity = UserEntity.builder().userId("abc12").email("kartikkhantal@gmail.com").firstName("kartik").lastName("khantal").mobileNo("8878767877").password("abc123").address(addressEntities).role(roleEntities).build();

        Mockito.when(userService.updateCustsomer(entity, entity.getEmail())).thenReturn(entity);
        UserEntity returned = this.userController.updateCustomer(entity.getEmail(), entity);
        assertEquals(entity, returned);
    }*/

   /* @Test
    public void getCustomerByEmail() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "Customer");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        UserEntity user = UserEntity.builder().userId("12qw").email("kartik@gmail.com").address(addressEntities).role(roleEntities).firstName("kartik").mobileNo("8878798922").lastName("Khantal").password("KArtik123").build();

        Mockito.when(userService.getByEmail(user.getEmail())).thenReturn(user);
        ResponseEntity<?> returned = this.userController.findByEmail(user.getEmail());
        assertEquals(user, returned.getBody());
    }*/


  /*  @Test
    public void getAllCustomer() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "Customer");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        UserEntity user = UserEntity.builder().userId("12qw").id(1L).email("kartik@gmail.com").address(addressEntities).role(roleEntities).firstName("kartik").mobileNo("8878798922").lastName("Khantal").password("KArtik123").build();
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(user);

        Mockito.when(userService.getAllCustomer()).thenReturn(userEntities);
        ResponseEntity<?> returned = this.userController.getALlCustomer();
        assertEquals(userEntities, returned.getBody());
    }*/

  /*  @Test
    public  void getAllUser(){
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "Customer");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        UserEntity user = UserEntity.builder().userId("12qw").id(1L).email("kartik@gmail.com").address(addressEntities).role(roleEntities).firstName("kartik").mobileNo("8878798922").lastName("Khantal").password("KArtik123").build();
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(user);

        Mockito.when(userService.getAllUser()).thenReturn(userEntities);
        ResponseEntity<?> returned = this.userController.getALlUser();
        assertEquals(userEntities, returned.getBody());

    }
*/
}
