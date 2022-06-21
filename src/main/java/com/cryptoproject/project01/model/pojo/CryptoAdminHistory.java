package com.cryptoproject.project01.model.pojo;

import java.time.Instant;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CryptoAdminHistory {

    private long id;
    private String symbol;
    
    private String adminId;


    private Boolean status;

    
    @UpdateTimestamp
    private Instant updateAt;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
    }


    public String getAdminId() {
        return adminId;
    }


    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }


    public String getSymbol() {
        return symbol;
    }


    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public Boolean getStatus() {
        return status;
    }


    public void setStatus(Boolean status) {
        this.status = status;
    }


    public Instant getUpdateAt() {
        return updateAt;
    }


    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }
}
