package com.cryptoproject.project01.model.repository;

import com.cryptoproject.project01.model.entity.CryptoEntity;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCryptoRepo extends PagingAndSortingRepository<CryptoEntity, Long> {
    // here PostCryptoRepo extends PagingAndSortingRepository interface which has some function that we can use to findAll(page) or other function
}
