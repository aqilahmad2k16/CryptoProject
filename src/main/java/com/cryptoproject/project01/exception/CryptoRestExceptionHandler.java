

package com.cryptoproject.project01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CryptoRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CryptoErrorResponse> handleException(CryptoNotFoundException e){
        CryptoErrorResponse err = new CryptoErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(e.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}

