package com.service;

import com.entity.Bank;
import com.entity.Document;
import com.model.DocModel;

public interface BankService {
    Bank getBankPay(DocModel docModel);

    Bank getBankRcp(DocModel docModel);

    Bank setBank(Bank bank);

    Bank create(Bank bank);

    void delete(long id);
}
