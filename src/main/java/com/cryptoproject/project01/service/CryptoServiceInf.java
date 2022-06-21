package com.cryptoproject.project01.service;



import java.util.List;

import com.cryptoproject.project01.model.dto.request.HistoryRequest;
import com.cryptoproject.project01.model.dto.request.CryptoRequest;

import com.cryptoproject.project01.model.dto.request.response.CryptoResponse;
import com.cryptoproject.project01.model.dto.request.response.HistoryResponse;
import com.cryptoproject.project01.model.entity.CryptoEntity;
// import com.cryptoproject.project01.model.entity.CryptoHistoryEntity;
import com.cryptoproject.project01.model.entity.CryptoHistoryEntity;

// import org.springframework.stereotype.Service;


public interface CryptoServiceInf{
  
    public CryptoResponse createNewCrypto(CryptoRequest crypto);
    
    public String delById(long id);

    public List<CryptoResponse> getcrypto();
    
    public String deleteAllCrypto();

    public CryptoResponse getCryptoByStatus(String status);

    public CryptoResponse updateById(CryptoRequest request, long id);

    

    public HistoryResponse updateNewActivity(HistoryRequest request);

    public List<CryptoEntity> findPaginatedCrypto(int pageNo, int pageSize);

    public List<HistoryResponse> getPaginationByNativeQuery(int pageNo, int pageSize);

    public List<CryptoHistoryEntity> getPaginationWithoutNativeQuery();
    
}
 