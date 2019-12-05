package com.gmail.dev.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
