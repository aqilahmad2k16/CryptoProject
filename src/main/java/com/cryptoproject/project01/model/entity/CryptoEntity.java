package com.cryptoproject.project01.model.entity;


import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
// import org.hibernate.annotations.UpdateTimestamp;
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="cryptodata")
public class CryptoEntity {
    
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
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @CreationTimestamp
    private Instant createAt;
    @Column(name="name")
    private String name;
    @Column(name="symbol")
    private String symbol;
    @Column(name="status")
    private Boolean status;
    @Column(name="marketCapital")
    private double marketCapital;
   
    
   
   

    
    

   

    







}
