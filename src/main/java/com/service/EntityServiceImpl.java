package com.service;

import com.entity.Bank;
import com.entity.Organization;
import com.interfaces.EntityService;
import com.model.DocModel;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl implements EntityService {
    public Bank getBankPay(DocModel docModel){
        Bank bank = new Bank();
        bank.setBic(docModel.getBIC_PAY());
        bank.setAccount(docModel.getBS_PAY());
        bank.setTreasuryaccount(docModel.getBS_KS_PAY());

        return bank;
    }

    public Bank getBankRcp(DocModel docModel){
        Bank bank = new Bank();
        bank.setBic(docModel.getBIC_RCP());
        bank.setAccount(docModel.getBS_RCP());
        bank.setTreasuryaccount(docModel.getBS_KS_RCP());

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
}
