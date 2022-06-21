package com.cryptoproject.project01.model.repository;


import java.util.List;

import com.cryptoproject.project01.model.entity.CryptoHistoryEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<CryptoHistoryEntity, Long> {

    @Query(value="select * from historylogs h INNER JOIN cryptodata c ON c.symbol=h.symbol where h.status=true AND c.status=true order by h.update_at desc", nativeQuery = true)
    Page<CryptoHistoryEntity> findPage(Pageable pageable);

    @Query(value="select*from historylogs hl INNER JOIN cryptodata cd ON cd.symbol=hl.symbol where hl.status=true AND cd.status=true order by hl.update_at desc limit 1", nativeQuery = true)
    List<CryptoHistoryEntity> findAllRecordsFromGivenCondtion();
    
}
