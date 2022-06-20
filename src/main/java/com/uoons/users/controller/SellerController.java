package com.uoons.users.controller;


import com.uoons.users.constants.UtilConstant;
import com.uoons.users.enitity.*;
import com.uoons.users.exception.EmptyInput;
import com.uoons.users.exception.NotFound;
import com.uoons.users.handler.ResponseHandler;
import com.uoons.users.service.SellerService;
import com.uoons.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    private UserService userService;

    @Autowired
    private SellerService sellerService;

    @PostMapping("/saveseller")
    public ResponseEntity<?> saveSeller(@RequestBody UserEntity seller) {
        try {
            UserEntity saveSeller = sellerService.saveSeller(seller);
            return ResponseHandler.generateResponse(UtilConstant.SUCCESS, HttpStatus.valueOf(200),UtilConstant.DONE,saveSeller);
        }
        catch (EmptyInput e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Please  Enter valid Email id or password",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }


    @PostMapping("/savebusinessdetails/{id}")
    public ResponseEntity<?> saveBusinessDetails(@PathVariable("id") Long id, @RequestBody BusinessDetails businessDetails) {
        try {
            BusinessDetails saveBusinessDetails = sellerService.saveBusinessDetails(businessDetails,id);
            return ResponseHandler.generateResponse(UtilConstant.SUCCESS, HttpStatus.valueOf(200),UtilConstant.DONE,saveBusinessDetails);
        }
        catch (EmptyInput e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Duplicate Entry!",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }
    }

    @PostMapping("/savebankdetails/{id}")
    public ResponseEntity<?> saveBankDetail(@PathVariable("id") Long id, @RequestBody BankDetails bankDetails) {
        try {
            BankDetails saveBankDetails = sellerService.saveBankDetails(bankDetails,id);
            return ResponseHandler.generateResponse(UtilConstant.SUCCESS, HttpStatus.valueOf(200),UtilConstant.DONE,saveBankDetails);
        }
        catch (EmptyInput e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Duplicate Entry",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }
    }

    @PostMapping("/savepickupaddress/{id}")
    public ResponseEntity<?> pickupAddress(@PathVariable("id") Long id, @RequestBody PickupAddress pickupAddress) {
        try {
            PickupAddress savePickupAddress = sellerService.savePickupAddress(pickupAddress,id);
            return ResponseHandler.generateResponse(UtilConstant.SUCCESS, HttpStatus.valueOf(200),UtilConstant.DONE,savePickupAddress);
        }
        catch (EmptyInput e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (NotFound e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Duplicate Entry",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

    @PutMapping("/updateseller/{id}")
    public ResponseEntity<?> updateSeller(@PathVariable("id") Long id, @RequestBody UserEntity user) {

        try {
            UserEntity updateSeller = sellerService.updateSeller(id, user);
            return ResponseHandler.generateResponse(UtilConstant.UPDATE,HttpStatus.valueOf(200),UtilConstant.DONE,updateSeller);
        }catch (EmptyInput e){
            return ResponseHandler.generateResponse(e.getErrorMessage(), HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (NotFound n){
            return ResponseHandler.generateResponse(n.getErrorMessage(),HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("please Enter the valid Email id",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

    @GetMapping("/getbusinessdetail/{userid}")
    public ResponseEntity<?> getBusinessDetail(@PathVariable("userid") Long id) {
        try {
            BusinessDetails businessDetails =sellerService.getBusinessDetail(id);
            return ResponseHandler.generateResponse(UtilConstant.GETDATA,HttpStatus.valueOf(200),UtilConstant.DONE,businessDetails);
        }catch (EmptyInput e){
            return ResponseHandler.generateResponse(e.getErrorMessage(), HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

    @PutMapping("/updatebusinessdetail/{userid}")
    public ResponseEntity<?> updateBusinessdetails(@PathVariable("userid") Long id, @RequestBody BusinessDetails businessDetails) {
        try {
            BusinessDetails updateBusinessDetails1 = sellerService.updateBusinessDetail(id, businessDetails);
            return ResponseHandler.generateResponse(UtilConstant.UPDATE,HttpStatus.valueOf(200),UtilConstant.DONE,updateBusinessDetails1);
        }catch (EmptyInput e){
            return ResponseHandler.generateResponse(e.getErrorMessage(), HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (NotFound n){
            return ResponseHandler.generateResponse(n.getErrorMessage(),HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Duplicate Entry",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }


    @GetMapping("/getbankdetail/{userid}")
    public ResponseEntity<?> getBankDetail(@PathVariable("userid") Long id) {
        try {
            BankDetails bankDetails =sellerService.getBankDetails(id);
            return ResponseHandler.generateResponse(UtilConstant.GETDATA,HttpStatus.valueOf(200),UtilConstant.DONE,bankDetails);
        }catch (EmptyInput e){
            return ResponseHandler.generateResponse(e.getErrorMessage(), HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }

    }



    @PutMapping("/updatebankdetail/{userid}")
    public ResponseEntity<?> updateBankDetail(@PathVariable("userid") Long id, @RequestBody BankDetails bankDetails) {
        try {
            BankDetails updateBankDetails1 = sellerService.updateBankDetails(id, bankDetails);
            return ResponseHandler.generateResponse(UtilConstant.UPDATE,HttpStatus.valueOf(200),UtilConstant.DONE,updateBankDetails1);
        }catch (EmptyInput e){
            return ResponseHandler.generateResponse(e.getErrorMessage(), HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (NotFound n){
            return ResponseHandler.generateResponse(n.getErrorMessage(),HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Duplicate Entry",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }


    @GetMapping("/getpickupaddress/{userid}")
    public ResponseEntity<?> getPickupAddress(@PathVariable("userid") Long id) {
        try {
            PickupAddress pickupAddress =sellerService.getPickupAddress(id);
            return ResponseHandler.generateResponse(UtilConstant.GETDATA,HttpStatus.valueOf(200),UtilConstant.DONE,pickupAddress);
        }catch (EmptyInput e){
            return ResponseHandler.generateResponse(e.getErrorMessage(), HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

    @PutMapping("/updatepickupaddress/{userid}")
    public ResponseEntity<?> updatePickupAddress(@PathVariable("userid") Long id, @RequestBody PickupAddress pickupAddress) {
        try {
            PickupAddress updatePickupAddress1 = sellerService.updatePickupAddress(id, pickupAddress);
            return ResponseHandler.generateResponse(UtilConstant.UPDATE,HttpStatus.valueOf(200),UtilConstant.DONE,updatePickupAddress1);
        }catch (EmptyInput e){
            return ResponseHandler.generateResponse(e.getErrorMessage(), HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }catch (NotFound n){
            return ResponseHandler.generateResponse(n.getErrorMessage(),HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Duplicate Entry",HttpStatus.valueOf(500),UtilConstant.ERROR,null);
        }
    }

}
