package com.service.impl;

import com.entity.Bank;
import com.entity.Document;
import com.entity.Organization;
import com.model.DocModel;
import com.repository.DocumentRepository;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Override
    public String findSum(List<Document> documentList){
        BigDecimal sum = BigDecimal.ZERO;

        for (int o=0; o<documentList.size(); o++) {
            BigDecimal bigDecimal = documentList.get(o).getSum();
            sum = sum.add(bigDecimal);
        }

        sum = sum.divide(BigDecimal.valueOf(documentList.size()));
        DecimalFormat f = new DecimalFormat("##.00");

        return f.format(sum);
    }

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public void newDocument(DocModel doc, Organization organizationpay,
                            Organization organizationrcp, Bank bankpay, Bank bankrcp) {
        Document document = new Document();
        document.setSum(doc.getAmountOut());
        document.setDate(doc.getDocDate());
        document.setGUID(doc.getDocGuid());
        document.setNumber(doc.getDocNum());
        document.setType(doc.getOperType());
        document.setPayerBank(bankpay);
        document.setRecipientBank(bankrcp);
        document.setPayerOrganization(organizationpay);
        document.setRecipientOrganization(organizationrcp);
        documentRepository.save(document);
    }
}
