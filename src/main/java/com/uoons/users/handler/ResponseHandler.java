package com.uoons.users.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {

    private ResponseHandler(){

    }

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus code, String status, Object responseObj) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("message", message);
        map.put("code", code.value());
        map.put("status", status);
        map.put("data", responseObj);


        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
