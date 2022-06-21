package com.cryptoproject.project01.model.repository;

import com.cryptoproject.project01.model.entity.CryptoHistoryEntity;



import com.cryptoproject.project01.model.entity.CryptoEntity;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<CryptoEntity, Long> {

    CryptoEntity findByName(String name);

    CryptoHistoryEntity save(CryptoHistoryEntity requestToEntity);

    CryptoHistoryEntity getBySymbol(String symbol);

    CryptoEntity findBySymbol(String symbol);
    //Doubt
    // @Query (value="SELECT*FROM cryptodata", nativeQuery=true)
    // public Page<CryptoEntity> findAll(Pageable paging);

    //Doubt

    
    
    
}
