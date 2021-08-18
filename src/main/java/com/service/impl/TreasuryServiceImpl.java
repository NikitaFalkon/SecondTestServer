package com.service.impl;

import com.entity.Treasury;
import com.repository.TreasuryRepository;
import com.service.TreasuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TreasuryServiceImpl implements TreasuryService {
    @Autowired
    TreasuryRepository treasuryRepository;

    @CachePut(cacheNames = "treasury")
    public Treasury create(String account) {
        Treasury treasury = treasuryRepository.findByAcc(account);
        if(treasury != null) {
            return treasury;
        }

        Treasury treasury1 = new Treasury();
        treasury1.setAcc(account);
        treasuryRepository.save(treasury1);

        return treasury1;
    }

    @Override
    @CacheEvict(value = {"treasury"}, allEntries = true)
    public void delete(long id) {
        Treasury treasury1 = treasuryRepository.findById(id);
        if (treasury1 != null) {
            treasury1.setExist(false);
            treasuryRepository.save(treasury1);
        }
    }
}
