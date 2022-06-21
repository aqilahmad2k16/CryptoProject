package com.cryptoproject.project01.exception;

import lombok.Data;

@Data
public class CryptoErrorResponse {// custom error response class
    private int status;
    private String message;
    private long timeStamp;

}
