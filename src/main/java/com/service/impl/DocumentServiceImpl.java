package com.service.impl;

import com.entity.Bank;
import com.entity.Document;
import com.entity.Organization;
import com.model.DocModel;
import com.repository.DocumentGrudRepository;
import com.repository.DocumentRepository;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    DocumentGrudRepository documentGrudRepository;

    /*@Override
    public BigDecimal getAverageSum(List<Document> documentList){
        BigDecimal sum = BigDecimal.ZERO;

        for (Document document : documentList) {
            BigDecimal bigDecimal = document.getSum();
            sum = sum.add(bigDecimal);
        }

        sum = sum.divide(BigDecimal.valueOf(documentList.size()));
        //DecimalFormat f = new DecimalFormat("##.00");

        return sum;
    }*/

    @Override
    public String getDocument(String guid) {
       return documentGrudRepository.findDocument(guid);
    }

    @Override
    public BigDecimal getAverageSum(List<Document> documentList) {
        /*BigDecimal sum = BigDecimal.ZERO;

        for (Document document : documentList) {
            BigDecimal bigDecimal = document.getAmount();
            sum = sum.add(bigDecimal);
        }

        sum = sum.divide(BigDecimal.valueOf(documentList.size()));
        //DecimalFormat f = new DecimalFormat("##.00");*/
        BigDecimal sum = documentGrudRepository.findAmount();

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
