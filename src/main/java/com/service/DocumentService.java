package com.service;

import com.entity.Bank;
import com.entity.Document;
import com.entity.Organization;
import com.model.DocModel;

import java.util.List;

public interface DocumentService {
    String findSum(List<Document> documentList);

    List<Document> findAll();

    void newDocument(DocModel doc, Organization organizationpay,
                     Organization organizationrcp, Bank bankpay, Bank bankrcp);
}
