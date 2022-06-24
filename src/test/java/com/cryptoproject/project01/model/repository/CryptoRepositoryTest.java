package com.cryptoproject.project01.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cryptoproject.project01.model.entity.CryptoEntity;

@SpringBootTest
public class CryptoRepositoryTest {
    @Autowired
    private CryptoRepository cryptoRepo;

    @Test
    void testFindByName() {
        CryptoEntity entity = cryptoRepo.findByName("BNB");

        //expected id 
        // int expecId = 1; //failed test case
        int expecId = 7;   // pass test case
        int actualId = (int) entity.getId();

        assertEquals(expecId, actualId);

    }
}
