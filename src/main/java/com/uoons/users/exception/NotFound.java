package com.uoons.users.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Integer errorCode;
    private String errorMessage;
}
