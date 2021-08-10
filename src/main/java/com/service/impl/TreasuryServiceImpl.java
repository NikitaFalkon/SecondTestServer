package com.service.impl;

import com.entity.Treasury;
import com.repository.TreasuryRepository;
import com.service.TreasuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreasuryServiceImpl implements TreasuryService {
    @Autowired
    TreasuryRepository treasuryRepository;

    public Treasury giveTreasury(String account) {
        Treasury treasury = treasuryRepository.findByAcc(account);
        if(treasury != null) {
            return treasury;
        }

        Treasury treasury1 = new Treasury();
        treasury1.setAcc(account);
        treasuryRepository.save(treasury1);

        return treasury1;
    }
}
