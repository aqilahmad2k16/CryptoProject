package com.cryptoproject.project01.service;


import com.cryptoproject.project01.model.dto.request.HistoryRequest;
import com.cryptoproject.project01.model.dto.request.response.HistoryResponse;

// import org.springframework.stereotype.Service;


public interface CryptoHistoryServiceInf {
    public HistoryResponse addDetails(HistoryRequest request);
}
