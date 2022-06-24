package com.cryptoproject.project01.service.CryptoImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cryptoproject.project01.commens.converter.CryptoConverter;
import com.cryptoproject.project01.model.dto.request.CryptoRequest;
import com.cryptoproject.project01.model.dto.request.response.CryptoResponse;
import com.cryptoproject.project01.model.entity.CryptoEntity;
import com.cryptoproject.project01.model.repository.CryptoRepository;
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CryptoServiceImplTest {

    @InjectMocks
    private CryptoServiceImpl cryptoServiceImpl;
    // we want to test the method of this service, so we are injecting his object

    @Mock
    private CryptoRepository cryptoRepository;
    // here, mock the object of repository and take test on fake data rather to take data from database 

    @Test
    void testCreateNewCrypto() {
        CryptoRequest request = new CryptoRequest(); 
        request.setName("IndianCrypto"); 
        // fake data we have taken for test purpose
        request.setStatus(false);
        request.setSymbol("IDC");
        request.setMarketCapital(78100125);

        CryptoEntity entityResponseDB = new CryptoEntity(); 
        // this data we expect from service method when we call  service method
        entityResponseDB.setName("IndianCrypto");
        entityResponseDB.setStatus(false);
        entityResponseDB.setSymbol("IDC");
        entityResponseDB.setMarketCapital(78100125);
        
        when(cryptoRepository.save(CryptoConverter.requestToEntity(request))).thenReturn(entityResponseDB);
        
        CryptoResponse actualRespo =  cryptoServiceImpl.createNewCrypto(request);
        // service method will return actual response

        assertEquals("IndianCrypto", actualRespo.getName());
        assertEquals(false, actualRespo.getStatus());
        assertEquals("IDC", actualRespo.getSymbol());
        assertEquals(78100125, actualRespo.getMarketCapital());



    }
}
