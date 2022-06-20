package com.uoons.users.ControllerTest;

import com.uoons.users.enitity.*;
import com.uoons.users.service.SellerService;
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
public class SellerController {

    @InjectMocks
    private com.uoons.users.controller.SellerController sellerController;

    @Mock
    private SellerService sellerService;

   /* @Test
    public void saveSeller() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();
        List<PickupAddress> addresses = new ArrayList<>();
        addresses.add(pickupAddress);

        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();

        Mockito.when(sellerService.saveSeller(user)).thenReturn(user);

        UserEntity returned = this.sellerController.saveSeller(user);
        assertEquals(user, returned);
    }*/

    /*@Test
    public void savePickupaddress() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();
        List<PickupAddress> addresses = new ArrayList<>();
        addresses.add(pickupAddress);

        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();

        Mockito.when(sellerService.savePickupAddress(pickupAddress, user.getEmail())).thenReturn(pickupAddress);
        PickupAddress returned = this.sellerController.pickupAddress(user.getEmail(), pickupAddress);
        assertEquals(pickupAddress, returned);
    }
*/
    /*@Test
    public void saveBusinessDetail() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();
        List<PickupAddress> addresses = new ArrayList<>();
        addresses.add(pickupAddress);

        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();

        Mockito.when(sellerService.saveBusinessDetails(businessDetails, user.getEmail())).thenReturn(businessDetails);
        BusinessDetails returned = this.sellerController.saveBusinessDetails(user.getEmail(), businessDetails);
        assertEquals(businessDetails, returned);
    }*/

   /* @Test
    public void saveBankDetail() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();
        List<PickupAddress> addresses = new ArrayList<>();
        addresses.add(pickupAddress);

        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();

        Mockito.when(sellerService.saveBankDetails(bankDetails, user.getEmail())).thenReturn(bankDetails);
//        BusinessDetails returned = this.sellerController.saveBusinessDetails(user.getEmail(), businessDetails);
        assertEquals(bankDetails, sellerController.saveBankDetail(user.getEmail(), bankDetails));
    }
*/

  /*  @Test
    public void updateSeller() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();
        List<PickupAddress> addresses = new ArrayList<>();
        addresses.add(pickupAddress);

        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();

        Mockito.when(sellerService.updateSeller(user.getEmail(), user)).thenReturn(user);

        ResponseEntity<?> returned = this.sellerController.updateSeller(user.getEmail(), user);
        assertEquals(user, returned.getBody());

    }*/

   /* @Test
    public void updatePickupAddress() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().pickupaddressId(1L).addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();


        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();

        Mockito.when(sellerService.updatePickupAddress(user.getEmail(), pickupAddress)).thenReturn(pickupAddress);

        assertEquals(pickupAddress, sellerController.updatePickupAddress(user.getEmail(), pickupAddress));
    }*/

  /*  @Test
    public void updateBusinessDetail() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().pickupaddressId(1L).addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();


        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();

        Mockito.when(sellerService.updateBusinessDetail(user.getEmail(), businessDetails)).thenReturn(businessDetails);

        assertEquals(businessDetails, sellerController.updateBusinessdetails(user.getEmail(), businessDetails));
    }

    @Test
    public void updateBankDetails() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().pickupaddressId(1L).pickupaddressId(1L).addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();


        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();

        Mockito.when(sellerService.updateBankDetails(user.getEmail(), bankDetails)).thenReturn(bankDetails);

        assertEquals(bankDetails, sellerController.updateBankDetail(user.getEmail(), bankDetails));
    }
*/
  /*  @Test
    public void getSellerByEmail() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().pickupaddressId(1L).pickupaddressId(1L).addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();


        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();


        Mockito.when(sellerService.getSeller(user.getEmail())).thenReturn(user);
        UserEntity returned = this.sellerController.findSellerByemail(user.getEmail());
        assertEquals(user, returned);
    }*/
   /* @Test
    public void getBusinessDetailsByEmail() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().pickupaddressId(1L).pickupaddressId(1L).addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();


        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();


        Mockito.when(sellerService.getBusinessDetail(user.getEmail())).thenReturn(businessDetails);
        BusinessDetails returned = this.sellerController.getBusinessDetail(user.getEmail());
        assertEquals(businessDetails, returned);
    }
    @Test
    public void getBankDetailsByEmail() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().pickupaddressId(1L).pickupaddressId(1L).addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();


        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();


        Mockito.when(sellerService.getBankDetails(user.getEmail())).thenReturn(bankDetails);
        BankDetails returned = this.sellerController.getBankDetail(user.getEmail());
        assertEquals(bankDetails, returned);
    }

    @Test
    public void getPickupaddressByEmail() {
        AddressEntity address = AddressEntity.builder().addressId(1L).addressType("Home").area("vijay nagar").alternateMobileNo("7787878788").city("indoor").hosueNo("12").landmark("Icai bhawan").pincode("458754").state("MP").build();
        List<AddressEntity> addressEntities = new ArrayList<>();
        addressEntities.add(address);

        RoleEntity role = new RoleEntity(1L, "SELLER");
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(role);

        PickupAddress pickupAddress = PickupAddress.builder().pickupaddressId(1L).pickupaddressId(1L).addressLine("vijaynagar").area("sector12").sellerId("Ab12").alternateMobileNo("7412589630").city("Indoor").landmark("C21").pincode("475114").build();


        BankDetails bankDetails = BankDetails.builder().bankDetailsId(1L).bankName("sbi").bankHolderName("Krtik khantal").sellerId("123ss").accountNumber("abhsdf123").ifscCode("abi320077").build();

        BusinessDetails businessDetails = BusinessDetails.builder().businessDetailId(1L).sellerId("asc123").gstNumber("hnka").panNumber("123456").build();

        UserEntity user = UserEntity.builder().id(1L).userId("ab12").firstName("kartik").lastName("khantal").password("kartik123").mobileNo("2233445566").email("kartik@gmail.com").role(roleEntities).address(addressEntities).build();


        Mockito.when(sellerService.getPickupAddress(user.getEmail())).thenReturn(pickupAddress);
       PickupAddress returned = this.sellerController.getPickupAddress(user.getEmail());
        assertEquals(pickupAddress, returned);
    }
*/


}