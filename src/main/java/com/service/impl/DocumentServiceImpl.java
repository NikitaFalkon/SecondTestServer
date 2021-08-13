package com.service.impl;

import com.entity.Bank;
import com.entity.Document;
import com.entity.Organization;
import com.model.DocModel;
import com.repository.DocumentCrudRepository;
import com.repository.DocumentRepository;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    DocumentCrudRepository documentCrudRepository;

    /*@Override
    public String getDocuments() {
        String s = "";
        List<Document> documentList = findAll();

        for (Document document : documentList) {
            s = s + documentGrudRepository.find(document.getGuid()) + "\n";
        }

        return s;
    }*/

    @Override
    public BigDecimal getAverageSum() {
        List<Document> documentList = findAll();
        BigDecimal sum = documentCrudRepository.findAmount();

        return sum;
    }

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public void create(DocModel doc, Organization organizationpay,
                            Organization organizationrcp, Bank bankpay, Bank bankrcp) {
        Document document = new Document();
        document.setAmount(doc.getAmountOut());
        document.setDate(doc.getDocDate());
        document.setGuid(doc.getDocGuid());
        document.setNumber(doc.getDocNum());
        document.setType(doc.getOperType());
        document.setPayerBank(bankpay);
        document.setRecipientBank(bankrcp);
        document.setPayerOrganization(organizationpay);
        document.setRecipientOrganization(organizationrcp);
        documentRepository.save(document);
    }
}
