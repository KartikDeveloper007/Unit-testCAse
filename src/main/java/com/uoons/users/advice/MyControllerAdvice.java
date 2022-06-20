package com.uoons.users.advice;

import com.uoons.users.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyInput.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInput e) {
        return new ResponseEntity<String>(e.getErrorMessage(), HttpStatus.valueOf(e.getErrorCode()));
    }



    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleEmptyInput(ConstraintViolationException e) {
        return new ResponseEntity<String>("Email-Id is not valid !! please enter valid email address!!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> handleListEmptyException(ServiceException e) {
        return new ResponseEntity<String>(e.getErrorMessage(), HttpStatus.valueOf(e.getErrorCode()));
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<String> handleNotFound(NotFound notFound) {
        return new ResponseEntity<String>(notFound.getErrorMessage(), HttpStatus.valueOf(notFound.getErrorCode()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleNotFound(DataIntegrityViolationException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(){
        return new ResponseEntity<String>("Request body is not present", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEnitityNotFound(EntityNotFoundException e) {
        return new ResponseEntity<String>("Employee not present in Database", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressTypeExistException.class)
    public ResponseEntity<String> handleAddressTypeExists(AddressTypeExistException addressTypeExistException) {
        return new ResponseEntity<String>(addressTypeExistException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?>handleBusinessException(BusinessException businessException){
        return  new ResponseEntity<>(businessException.getMessage(), HttpStatus.valueOf(businessException.getCode()));
    }
}
