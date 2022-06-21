package com.cryptoproject.project01.service.CryptoHistoryServiceImplementation;

import com.cryptoproject.project01.commens.converter.HistoryConverter;
import com.cryptoproject.project01.model.dto.request.HistoryRequest;
import com.cryptoproject.project01.model.dto.request.response.HistoryResponse;
import com.cryptoproject.project01.model.repository.HistoryRepository;
import com.cryptoproject.project01.service.CryptoHistoryServiceInf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CryptoHistoryServiceImpl implements CryptoHistoryServiceInf {
    
    @Autowired
    private HistoryRepository historyRepository;

    public HistoryResponse addDetails(HistoryRequest request){
        return HistoryConverter.entityToResponse(historyRepository.save(HistoryConverter.requestToEntity(request)));
    }

    

    
}
