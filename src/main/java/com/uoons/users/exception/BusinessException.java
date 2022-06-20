package com.uoons.users.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends  Exception {
    Integer code;
    String message;

    public BusinessException(String message, Integer code) {
        super(message);
        this.message=message;
        this.code = code;
    }


}