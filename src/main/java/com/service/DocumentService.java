package com.service;

import com.entity.Bank;
import com.entity.Document;
import com.entity.Organization;
import com.model.DocModel;

import java.math.BigDecimal;
import java.util.List;

public interface DocumentService {
    BigDecimal getAverageSum();

    List<Document> findAll();

    void create(DocModel doc, Organization organizationpay,
                     Organization organizationrcp, Bank bankpay, Bank bankrcp);

    //String getDocuments();
}
