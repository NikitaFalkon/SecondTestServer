package com.interfaces;

import com.entity.Bank;
import com.entity.Organization;
import com.model.DocModel;

public interface EntityService {
    public Bank getBankPay(DocModel docModel);
    public Bank getBankRcp(DocModel docModel);
    public Organization getInfPay(DocModel docModel);
    public Organization getInfRcp(DocModel docModel);
}
