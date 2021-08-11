package com.service;

import com.entity.Bank;
import com.entity.Treasury;
import com.model.DocModel;

public interface BankService {
    Bank getBankPay(DocModel docModel);

    Bank getBankRcp(DocModel docModel);

    Bank setBank(Bank bank);

    Bank create(Bank bank);
}
