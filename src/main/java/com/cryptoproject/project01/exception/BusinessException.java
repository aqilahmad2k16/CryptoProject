package com.cryptoproject.project01.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@EqualsAndHashCode(callSuper=false)
public class BusinessException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
    private static final long seriaLVersionUID = 1L;

}
