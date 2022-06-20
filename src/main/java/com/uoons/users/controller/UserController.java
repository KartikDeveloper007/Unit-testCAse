package com.uoons.users.controller;

import com.uoons.users.constants.UtilConstant;
import com.uoons.users.dto.AddressType;
import com.uoons.users.enitity.AddressEntity;
import com.uoons.users.enitity.UserEntity;
import com.uoons.users.exception.AddressTypeExistException;
import com.uoons.users.exception.EmptyInput;
import com.uoons.users.exception.NotFound;
import com.uoons.users.handler.ResponseHandler;
import com.uoons.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/savecustomer")
    public ResponseEntity<?> saveCustomer(@RequestBody UserEntity customer) {
        try {
            UserEntity saveCustomer = userService.saveCustomer(customer);
          return ResponseHandler.generateResponse(UtilConstant.SUCCESS, HttpStatus.valueOf(200),UtilConstant.DONE,saveCustomer);
        }
        catch (EmptyInput e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
      catch (Exception e){
            return ResponseHandler.generateResponse("Please  Enter valid Email id or password",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }

    }

    @PutMapping("/updatecustomer/{userid}")
    public ResponseEntity<?> updateCustomer(@PathVariable("userid") Long userid, @RequestBody UserEntity userEntity) {

        try {
            UserEntity updateUser=userService.updateCustsomer(userEntity,userid);
            return ResponseHandler.generateResponse(UtilConstant.UPDATE,HttpStatus.valueOf(200),UtilConstant.DONE,updateUser);
        }catch (EmptyInput e){
            return ResponseHandler.generateResponse(e.getErrorMessage(), HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (NotFound n){
            return ResponseHandler.generateResponse(n.getErrorMessage(),HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("please enter the valid email id or password",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

    @PostMapping("/saveaddress/{userid}")
    public ResponseEntity<?> saveAddress(@PathVariable("userid") Long userid, @RequestBody AddressEntity address , @RequestParam("address") AddressType addressType) {
        try {
            AddressEntity addressEntity=userService.saveAddress(address,userid,addressType);
            return ResponseHandler.generateResponse(UtilConstant.SUCCESS,HttpStatus.valueOf(200),UtilConstant.DONE,addressEntity);
        }catch (AddressTypeExistException a){
            return ResponseHandler.generateResponse(a.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

    @GetMapping("/getaddresses/{userid}")
    public ResponseEntity<?> getAllAddresses(@PathVariable("userid") Long userid){
        try {
            List<AddressEntity> addresses =userService.getAddresses(userid);
            return ResponseHandler.generateResponse(UtilConstant.GETDATA,HttpStatus.valueOf(200),UtilConstant.DONE,addresses);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

    @PutMapping("/updateaddress/{userid}")
    public ResponseEntity<?> updateAddress(@PathVariable("userid") Long userid, @RequestBody AddressEntity address){
        try {
            AddressEntity updateAddressEntity=userService.updateAddress(address, userid);
            return ResponseHandler.generateResponse(UtilConstant.UPDATE,HttpStatus.valueOf(200),UtilConstant.DONE,updateAddressEntity);
        }catch (AddressTypeExistException e){
            return ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

    @PutMapping("/primaryaddress/{userid}")
    public ResponseEntity<?> primaryAddress(@PathVariable("userid") Long userid, @RequestParam("address") AddressType addressType){
        try {
            String primaryAddress = userService.isPrimaryAddress(userid,addressType);
            return ResponseHandler.generateResponse(UtilConstant.SUCCESS,HttpStatus.valueOf(200),UtilConstant.DONE,primaryAddress);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

    @GetMapping("/getcustomerbyid/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            UserEntity findCustomerId = userService.getById(id);
            return ResponseHandler.generateResponse(UtilConstant.GETDATA, HttpStatus.valueOf(200),UtilConstant.DONE,findCustomerId);
        }
        catch (NotFound e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }
}


