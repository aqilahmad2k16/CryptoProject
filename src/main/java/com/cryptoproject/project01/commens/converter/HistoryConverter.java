package com.cryptoproject.project01.commens.converter;



import java.util.ArrayList;
import java.util.List;

import com.cryptoproject.project01.model.dto.request.HistoryRequest;
import com.cryptoproject.project01.model.dto.request.response.HistoryResponse;
import com.cryptoproject.project01.model.entity.CryptoHistoryEntity;

public class HistoryConverter {
    public static CryptoHistoryEntity requestToEntity(HistoryRequest request){
        CryptoHistoryEntity activityByAdminEntity=new CryptoHistoryEntity();
        activityByAdminEntity.setAdminId(request.getAdminId());
        activityByAdminEntity.setStatus(request.getStatus());
        activityByAdminEntity.setSymbol(request.getSymbol());
        activityByAdminEntity.setId(request.getId());
        activityByAdminEntity.setUpdateAt(request.getUpdateAt());
        return activityByAdminEntity;
    }

    public static HistoryResponse entityToResponse(CryptoHistoryEntity entity){
        HistoryResponse adminResponse=new HistoryResponse();
        adminResponse.setAdminId(entity.getAdminId());
        adminResponse.setStatus(entity.getStatus());
        adminResponse.setSymbol(entity.getSymbol());
        adminResponse.setId(entity.getId());
        adminResponse.setUpdateAt(entity.getUpdateAt());
        return adminResponse;
    }

    public static List<HistoryResponse> listOfEntityToListOfResponse(List<CryptoHistoryEntity> entity){
        List<HistoryResponse> list=new ArrayList<>();
        for(CryptoHistoryEntity e: entity){
            list.add(HistoryConverter.entityToResponse(e));
        }

        return list;
    }
}
