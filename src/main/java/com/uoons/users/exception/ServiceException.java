package com.uoons.users.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Integer errorCode;
    private String errorMessage;
}