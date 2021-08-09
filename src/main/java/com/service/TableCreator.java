package com.service;

import com.entity.Bank;
import com.entity.Document;
import com.entity.Organization;
import com.model.DocModel;
import com.repository.BankRepository;
import com.repository.DocumentRepository;
import com.repository.OrganizationRepository;
import com.repository.TreasuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableCreator {
    @Autowired
    BankRepository bankRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    EntityServiceImpl entityService;
    @Autowired
    TreasuryRepository treasuryRepository;


    public void create(List<DocModel> docs) {
        docs.forEach(doc -> {
            Bank bankPay = entityService.getBankPay(doc);
            Organization infPay = entityService.getInfPay(doc);
            Bank bankRcp = entityService.getBankRcp(doc);
            Organization infRcp = entityService.getInfRcp(doc);
            newDocument(doc, infPay, infRcp, bankPay, bankRcp);
        });
    }

    public void newDocument(DocModel doc, Organization organizationpay, Organization organizationrcp, Bank bankpay, Bank bankrcp) {
        Document document = new Document();
        document.setSum(doc.getAmountOut());
        document.setDate(doc.getDocDate());
        document.setGUID(doc.getDocGUID());
        document.setNumber(doc.getDocNum());
        document.setType(doc.getOperType());

        if (!bankRepository.existsBankByBic(bankpay.getBic()) ||
               !bankRepository.existsBankByAccount(bankpay.getAccount())) {
            document.setPayerBank(newBank(bankpay));
        } else {
            document.setPayerBank(bankRepository.findByTreasury(bankpay.getTreasury()));
        }

        if (!bankRepository.existsBankByBic(bankrcp.getBic()) ||
                !bankRepository.existsBankByAccount(bankrcp.getAccount())) {
            document.setRecipientBank(newBank(bankrcp));
        } else {
            document.setRecipientBank(bankRepository.findByTreasury(bankrcp.getTreasury()));
        }

        if (!organizationRepository.existsOrganizationByInn(organizationpay.getInn()) &&
                !organizationRepository.existsOrganizationByKpp(organizationpay.getKpp())) {
            if (!organizationRepository.existsOrganizationByCname(organizationpay.getCname())) {
                document.setPayerOrganization(newOrganization(organizationpay));
            } else {
                document.setPayerOrganization(organizationRepository.findByCname(organizationpay.getCname()));
            }
        } else {
            document.setPayerOrganization(organizationRepository.findByInn(organizationpay.getInn()));
        }

        if (!organizationRepository.existsOrganizationByInn(organizationrcp.getInn()) &&
                !organizationRepository.existsOrganizationByKpp(organizationrcp.getKpp())) {
            if (!organizationRepository.existsOrganizationByCname(organizationrcp.getCname())) {
                document.setRecipientOrganization(newOrganization(organizationrcp));
            } else {
                document.setRecipientOrganization(organizationRepository.findByCname(organizationrcp.getCname()));
            }
        } else {
            document.setRecipientOrganization(organizationRepository.findByInn(organizationrcp.getInn()));
        }

        documentRepository.save(document);
    }

    public Bank newBank(Bank bank) {
        bankRepository.save(bank);

        return bank;
    }

    private Organization newOrganization(Organization organization) {
        organizationRepository.save(organization);

        return organization;
    }
}
