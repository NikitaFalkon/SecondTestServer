package com.service;

import com.entity.Treasury;
import com.entity.Bank;
import com.entity.Organization;
import com.interfaces.EntityService;
import com.model.DocModel;
import com.repository.TreasuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl implements EntityService {
    @Autowired
    TreasuryRepository accountRepository;

    public Bank getBankPay(DocModel docModel){
        Bank bank = new Bank();
        bank.setBic(docModel.getBIC_PAY());
        bank.setAccount(docModel.getBS_PAY());
        bank.setTreasury(giveTreasury(docModel.getBS_KS_PAY()));

        return bank;
    }

    public Bank getBankRcp(DocModel docModel){
        Bank bank = new Bank();
        bank.setBic(docModel.getBIC_RCP());
        bank.setAccount(docModel.getBS_RCP());
        bank.setTreasury(giveTreasury(docModel.getBS_KS_RCP()));

        return bank;
    }

    public Organization getInfPay(DocModel docModel){
        Organization organization = new Organization();
        organization.setInn(docModel.getINN_PAY());
        organization.setCname(docModel.getcName_PAY());
        organization.setKpp(docModel.getKPP_PAY());

        return organization;
    }

    public Organization getInfRcp(DocModel docModel){
        Organization organization = new Organization();
        organization.setInn(docModel.getINN_RCP());
        organization.setCname(docModel.getcName_RCP());
        organization.setKpp(docModel.getKPP_RCP());

        return organization;
    }

    public Treasury giveTreasury(String account) {
        if(accountRepository.existsTreasuryByAcc(account)) {
           return accountRepository.findByAcc(account);
        }

        Treasury treasury = new Treasury();
        treasury.setAcc(account);
        accountRepository.save(treasury);

        return treasury;
    }
}
