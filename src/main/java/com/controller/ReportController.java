package com.controller;

import com.model.DocModel;
import com.service.OrganizationService;
import com.service.impl.BankServiceImpl;
import com.service.impl.DocumentServiceImpl;
import com.service.impl.TreasuryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {
    @Autowired
    BankServiceImpl bankService;
    @Autowired
    OrganizationService organizationService;
    @Autowired
    DocumentServiceImpl documentService;
    @Autowired
    TreasuryServiceImpl treasuryService;

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody List<DocModel> docModelList) {
        String response = docModelList.toString();
        getDocs(docModelList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public void getDocs(List<DocModel> docs) {
        docs.forEach(doc -> {
            documentService.create(doc,
                    organizationService.getOrganization(organizationService.getInfPay(doc)),
                    organizationService.getOrganization(organizationService.getInfRcp(doc)),
                    bankService.setBank(bankService.getBankPay(doc)),
                    bankService.setBank(bankService.getBankRcp(doc)));
        });
    }

}
