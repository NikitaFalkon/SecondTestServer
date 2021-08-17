package com.service.impl;

import com.entity.Bank;
import com.model.DocModel;
import com.repository.BankRepository;
import com.service.BankService;
import com.service.TreasuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankRepository bankRepository;
    @Autowired
    TreasuryService treasuryService;

    @Override
    @Cacheable(cacheNames = "docModel")
    public Bank getBankPay(DocModel docModel) {
        Bank bank = new Bank();
        bank.setBic(docModel.getBic_Pay());
        bank.setAccount(docModel.getBs_Pay());
        bank.setTreasury(treasuryService.create(docModel.getBs_Ks_Pay()));

        return bank;
    }

    @Override
    @Cacheable(cacheNames = "docModel")
    public Bank getBankRcp(DocModel docModel) {
        Bank bank = new Bank();
        bank.setBic(docModel.getBic_Rcp());
        bank.setAccount(docModel.getBs_Rcp());
        bank.setTreasury(treasuryService.create(docModel.getBs_Ks_Rcp()));

        return bank;
    }

    @Override
    public Bank setBank(Bank bank) {
        if (!bankRepository.existsBankByBic(bank.getBic()) ||
                !bankRepository.existsBankByAccount(bank.getAccount())) {
            return create(bank);
        } else {
            return bankRepository.findByTreasury(bank.getTreasury());
        }
    }

    @Override
    public Bank create(Bank bank) {
        bankRepository.save(bank);

        return bank;
    }
}
