package com.cryptoproject.project01.model.pojo;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Crypto {
    
    private long id;
    @CreationTimestamp
    private Instant createAt;
    private String name;
    private String symbol;
    private Boolean status;
    private double marketCapital;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Instant getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public double getMarketCapital() {
        return marketCapital;
    }
    public void setMarketCapital(double marketCapital) {
        this.marketCapital = marketCapital;
    }
   
}
