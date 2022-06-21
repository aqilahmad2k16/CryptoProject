package com.cryptoproject.project01.service.CryptoImplementation;

import java.util.List;

import javax.transaction.Transactional;

import com.cryptoproject.project01.commens.converter.CryptoConverter;
import com.cryptoproject.project01.commens.converter.HistoryConverter;
import com.cryptoproject.project01.exception.BusinessException;
import com.cryptoproject.project01.exception.CryptoNotFoundException;
import com.cryptoproject.project01.model.dto.request.CryptoRequest;
import com.cryptoproject.project01.model.dto.request.HistoryRequest;
import com.cryptoproject.project01.model.dto.request.response.CryptoResponse;
import com.cryptoproject.project01.model.dto.request.response.HistoryResponse;
import com.cryptoproject.project01.model.entity.CryptoEntity;
import com.cryptoproject.project01.model.entity.CryptoHistoryEntity;
import com.cryptoproject.project01.model.repository.CryptoRepository;
import com.cryptoproject.project01.model.repository.HistoryRepository;
import com.cryptoproject.project01.model.repository.PostCryptoRepo;
import com.cryptoproject.project01.service.CryptoHistoryServiceInf;
import com.cryptoproject.project01.service.CryptoServiceInf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CryptoServiceImpl implements CryptoServiceInf {
    @Autowired
    private CryptoRepository repository;

    @Autowired
    private CryptoHistoryServiceInf cryptoHistoryServiceInf;

    @Autowired
    private PostCryptoRepo postCryptoRepo;

    @Autowired
    private HistoryRepository historyRepository;

    public CryptoServiceImpl() {

    }

    @Override
    public CryptoResponse createNewCrypto(CryptoRequest request) {
        // throw an exception when name of crypto is null or length =0
        if(request.getName().isEmpty() || request.getName().length()==0){
            throw new BusinessException("601", "Please send proper name, it's blank");
        }


        try{
            return CryptoConverter.entityToResponse(repository.save(CryptoConverter.requestToEntity(request)));
        }catch(IllegalArgumentException e){// IllegalArgumentException when whole data about crypto is null
            throw new BusinessException("602", "given crypto is null" + e.getMessage());
        }catch(Exception e){// any other problem occur with the businnes logic
            throw new BusinessException("603", "there is some service error"+ e.getMessage());
        }

        
    }

    @Override
    public String delById(long id) {
        repository.deleteById(id);
        return "your record is deleted";
    }

    @Override
    public List<CryptoResponse> getcrypto() {
        return CryptoConverter.listOfEntityToListOfResponse(repository.findAll());
    }

    @Override
    public String deleteAllCrypto() {
        repository.deleteAll();
        return "Crypto Data have deleted";
    }

    @Override
    public CryptoResponse getCryptoByStatus(String symbol) {
        CryptoEntity entity = repository.findBySymbol(symbol);
        return CryptoConverter.entityToResponse(entity);
    }

    @Override
    public CryptoResponse updateById(CryptoRequest request, long id) {

        if(id<0 || !(repository.existsById(id)) ){
            throw new CryptoNotFoundException("this crypto id is not present  " + id);
        }

        CryptoEntity en = repository.getById(id);
        en.setCreateAt(en.getCreateAt());
        en.setStatus(CryptoConverter.requestToEntity(request).getStatus());
        en.setSymbol(CryptoConverter.requestToEntity(request).getSymbol());
        en.setName(CryptoConverter.requestToEntity(request).getName());
        en.setMarketCapital(CryptoConverter.requestToEntity(request).getMarketCapital());
        // return
        // CryptoConverter.entityToResponse(repository.save(CryptoConverter.requestToEntity(request)));

        return CryptoConverter.entityToResponse(repository.save(en));
    }

    @Transactional // this annotation helps make consistency between two tables, if there is
                   // exception occur before the other table then it won't allow to store the data
                   // in the firs.
    @Override
    public HistoryResponse updateNewActivity(HistoryRequest request) {
        CryptoEntity entity = repository.findBySymbol(request.getSymbol());
        entity.setStatus(request.getStatus());
        repository.save(entity);
        // int y = 2/0; // at this line exception wiill occur it means that data int
        // cryptodata table get store but after this line program will terminate and
        // data in second table that is historylogs won't store// so in order to
        // overcome this problem, in such a case where two table are linked with each
        // other in that case we use @Transacational annotation for better data flow or
        // consistency

        // we don't want that if there is an exception thown then, it won't be update in
        // any of the table
        // System.out.println(y);
        return cryptoHistoryServiceInf.addDetails(request);
    }

    @Override // Pagination code
    public List<CryptoEntity> findPaginatedCrypto(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        // PageRequest.of(int page, int size)
        // Creates a new unsorted PageRequest

        Page<CryptoEntity> pageResult = postCryptoRepo.findAll(paging);
        // The findAll(Pageable pageable) method by default returns a Page object. A
        // Page object provides lots of extra useful information other than just list of
        // employees in current page. E.g. A Page object has the number of total pages,
        // number of the current page and well as whether current page is first page or
        // last page
        return pageResult.toList();
    }

    @Override
    public List<HistoryResponse> getPaginationByNativeQuery(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<CryptoHistoryEntity> pageResult = historyRepository.findPage(paging);
        return HistoryConverter.listOfEntityToListOfResponse(pageResult.toList());
    }

    @Override
    public List<CryptoHistoryEntity> getPaginationWithoutNativeQuery() {

        return historyRepository.findAllRecordsFromGivenCondtion();
    }

}
