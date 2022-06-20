package com.uoons.users.controller;


import com.uoons.users.constants.UtilConstant;
import com.uoons.users.enitity.UserEntity;
import com.uoons.users.exception.EmptyInput;
import com.uoons.users.exception.NotFound;
import com.uoons.users.handler.ResponseHandler;
import com.uoons.users.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/saveadmin")
    public ResponseEntity<?> saveAdmin(@RequestBody UserEntity admin) {
        try {
            UserEntity saveAdmin = adminService.saveAdmin(admin);
            return ResponseHandler.generateResponse(UtilConstant.SUCCESS, HttpStatus.valueOf(200),UtilConstant.DONE,saveAdmin);
        }
        catch (EmptyInput e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Please Enter the Valid Email id",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }
    }


    @PutMapping("/deactive/{id}")
    public ResponseEntity<?> deactiveUser(@PathVariable("id") Long id) {
        try {
            adminService.isDeleted(id);
            return ResponseHandler.generateResponse("User is Deactivated !", HttpStatus.valueOf(200),UtilConstant.DONE,null);
        }
        catch (NotFound e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<?> activeUser(@PathVariable("id") Long id) {
        try {
            adminService.isActive(id);
            return ResponseHandler.generateResponse("User is Activated !", HttpStatus.valueOf(200),UtilConstant.DONE,null);
        }
        catch (NotFound e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }
    }


    @GetMapping("/getalluser")
    public ResponseEntity<?> getALlUser() {
        try {
            List<UserEntity> findAllCustomer = adminService.getAllUser();
            return ResponseHandler.generateResponse(UtilConstant.GETDATA, HttpStatus.valueOf(200),UtilConstant.DONE,findAllCustomer);
        }
        catch (NotFound e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }
    }


    @GetMapping("/getallcustomer")
    public ResponseEntity<?> getALlCustomer() {
        try {
            List<UserEntity> findAllCustomer = adminService.getAllCustomer();
            return ResponseHandler.generateResponse(UtilConstant.GETDATA, HttpStatus.valueOf(200),UtilConstant.DONE,findAllCustomer);
        }
        catch (NotFound e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }
    }


    @GetMapping("/getseller/{id}")
    public ResponseEntity<?> findSellerById(@PathVariable("id") Long id) {
        try {
            UserEntity seller = adminService.getSeller(id);
            return ResponseHandler.generateResponse(UtilConstant.GETDATA, HttpStatus.valueOf(200),UtilConstant.DONE,seller);
        }
        catch (NotFound e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }

    }

    @GetMapping("/getallseller")
    public ResponseEntity<?> getAllSeller() {
        try {
            List<UserEntity> sellerAll = adminService.getAllSeller();
            return ResponseHandler.generateResponse(UtilConstant.GETDATA, HttpStatus.valueOf(200),UtilConstant.DONE,sellerAll);
        }
        catch (NotFound e){
            return  ResponseHandler.generateResponse(e.getErrorMessage(),HttpStatus.valueOf(502),UtilConstant.FAILED,null);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse("Server Not Found",HttpStatus.valueOf(504),UtilConstant.ERROR,null);
        }
    }
}

