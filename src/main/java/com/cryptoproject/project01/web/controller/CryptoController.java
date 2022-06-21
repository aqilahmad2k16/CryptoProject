package com.cryptoproject.project01.web.controller;



import java.util.List;

// import com.cryptoproject.project01.exception.CryptoErrorResponse;
// import com.cryptoproject.project01.exception.CryptoNotFoundException;
import com.cryptoproject.project01.model.dto.request.CryptoRequest;
import com.cryptoproject.project01.model.dto.request.HistoryRequest;
import com.cryptoproject.project01.model.dto.request.response.CryptoResponse;
import com.cryptoproject.project01.model.dto.request.response.HistoryResponse;
import com.cryptoproject.project01.model.entity.CryptoEntity;
import com.cryptoproject.project01.model.entity.CryptoHistoryEntity;
import com.cryptoproject.project01.model.repository.CryptoRepository;
// import com.cryptoproject.project01.model.entity.CryptoHistoryEntity;
import com.cryptoproject.project01.service.CryptoImplementation.CryptoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class CryptoController {
    
    @Autowired
    private CryptoServiceImpl cryptoServiceImp;

    @Autowired
    private CryptoRepository cryptoRepository;
    
    //post Api
    @PostMapping("/crypto")
    public CryptoResponse createNewCrypto(@RequestBody CryptoRequest request){
        
        return cryptoServiceImp.createNewCrypto(request);
    }

    // delete Api
    @DeleteMapping("/crypto/{id}")
    public String delById(@PathVariable Long id){
        return cryptoServiceImp.delById(id);
    }

    @DeleteMapping("/crypto")
    public String deleteAllCrypto(){
        return cryptoServiceImp.deleteAllCrypto();
    }

    @GetMapping("/crypto")
    public List<CryptoResponse> getcrypto(){
        return cryptoServiceImp.getcrypto();
    }

    @GetMapping("/crypto/{symbol}")
    public ResponseEntity<CryptoResponse> getCryptoByStatus(@PathVariable String symbol){
        CryptoResponse cryptoresponse = cryptoServiceImp.getCryptoByStatus(symbol);
        return new ResponseEntity<CryptoResponse>(cryptoresponse, HttpStatus.FOUND);
    }

    // update API
    @PutMapping("/crypto/{id}")
    public CryptoResponse updateById(@RequestBody CryptoRequest request, @PathVariable Long id){
        
        
        return cryptoServiceImp.updateById(request, id);
    }

        

    @PostMapping("/crypto/history")
    public HistoryResponse updateNewActivity(@RequestBody HistoryRequest request){
        return cryptoServiceImp.updateNewActivity(request);
    }

    @GetMapping("/crypto/{pageNo}/{pageSize}")// Pagination code
    public List<CryptoEntity> findPaginatedCrpto(@PathVariable int pageNo, @PathVariable int pageSize){
        return cryptoServiceImp.findPaginatedCrypto(pageNo, pageSize);
    }

    @GetMapping("/crypto/native/{pageNo}/{pageSize}")// by native query
    public List<HistoryResponse> getPaginationByNativeQuery(@PathVariable int pageNo, @PathVariable int pageSize){
        return cryptoServiceImp.getPaginationByNativeQuery(pageNo, pageSize);
    }

    @GetMapping("/crypto/pagination")// crypto with pagination
    public List<CryptoHistoryEntity> getPaginationWithoutNativeQuery(){
        return cryptoServiceImp.getPaginationWithoutNativeQuery();
    }

    // @ExceptionHandler
    // public ResponseEntity<CryptoErrorResponse> handleException(CryptoNotFoundException e){
    //     CryptoErrorResponse err = new CryptoErrorResponse();
    //     err.setStatus(HttpStatus.NOT_FOUND.value());
    //     err.setMessage(e.getMessage());
    //     err.setTimeStamp(System.currentTimeMillis());
    //     return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    // }
    

   






    
}
