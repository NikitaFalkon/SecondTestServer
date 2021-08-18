package com.service.impl;

import com.entity.Bank;
import com.entity.Document;
import com.entity.Organization;
import com.model.DocModel;
import com.repository.DocumentRepository;
import com.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Override
    @Cacheable(cacheNames = "sum")
    public BigDecimal getAverageSum() {
        BigDecimal sum = documentRepository.findAmount();

        return sum;
    }

    @Override
    @Cacheable(cacheNames = "documentList")
    public List<Document> findAll() {
        List<Document> documentList = documentRepository.findAll();
        return documentList;
    }

    @Override
    @CacheEvict(value = {"documentList", "sum"}, allEntries = true)
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

    @Override
    @CacheEvict(value = {"documentList", "sum"}, allEntries = true)
    public void delete(long id) {
        Document document1 = documentRepository.findById(id);
        if (document1 != null) {
            document1.setExist(false);
            documentRepository.save(document1);
        }
    }
}
