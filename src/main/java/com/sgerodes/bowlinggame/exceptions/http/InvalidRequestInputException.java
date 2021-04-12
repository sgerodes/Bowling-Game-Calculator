package com.sgerodes.bowlinggame.exceptions.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidRequestInputException extends RuntimeException {
    public InvalidRequestInputException(String msg) {
        super(msg);
    }
}
