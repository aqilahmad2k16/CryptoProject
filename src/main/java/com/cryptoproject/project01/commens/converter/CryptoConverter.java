package com.cryptoproject.project01.commens.converter;

import java.util.ArrayList;
import java.util.List;

import com.cryptoproject.project01.model.dto.request.CryptoRequest;
import com.cryptoproject.project01.model.dto.request.response.CryptoResponse;
import com.cryptoproject.project01.model.entity.CryptoEntity;

public class CryptoConverter {
    public static CryptoEntity requestToEntity(CryptoRequest request){
        CryptoEntity cryptoentity=new CryptoEntity();
        cryptoentity.setId(request.getId());
        cryptoentity.setSymbol(request.getSymbol());
        cryptoentity.setCreateAt(request.getCreateAt());
        cryptoentity.setName(request.getName());
        cryptoentity.setStatus(request.getStatus());
        cryptoentity.setMarketCapital(request.getMarketCapital());
        
        return cryptoentity;
        
    }

    public static CryptoResponse entityToResponse(CryptoEntity entity){
        CryptoResponse cryptoresponse = new CryptoResponse();
        cryptoresponse.setId(entity.getId());
        cryptoresponse.setSymbol(entity.getSymbol());
        cryptoresponse.setCreateAt(entity.getCreateAt());
        cryptoresponse.setName(entity.getName());
        cryptoresponse.setStatus(entity.getStatus());
        cryptoresponse.setMarketCapital(entity.getMarketCapital());
        return cryptoresponse;
    }

    public static List<CryptoResponse> listOfEntityToListOfResponse(List<CryptoEntity> entity){
        List<CryptoResponse> list=new ArrayList<>();
        for(CryptoEntity e: entity){
            list.add(CryptoConverter.entityToResponse(e));
        }

        return list;
    }

    public static List<CryptoResponse> returnListOfResponseByStatus(List<CryptoEntity> entity, String symbol){
        List<CryptoResponse> list=new ArrayList<>();
        for(CryptoEntity e:entity){
            if(e.getSymbol() == symbol){
                list.add(CryptoConverter.entityToResponse(e));
            }
        }
        return list;
    }
}


