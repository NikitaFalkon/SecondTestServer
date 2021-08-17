package com.controller;

import com.model.DocModel;
import com.service.BankService;
import com.service.DocumentService;
import com.service.OrganizationService;
import com.service.TreasuryService;
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
    BankService bankService;
    @Autowired
    OrganizationService organizationService;
    @Autowired
    DocumentService documentService;
    @Autowired
    TreasuryService treasuryService;

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody List<DocModel> docModelList) {
        String response = docModelList.toString();
        createDocs(docModelList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public void createDocs(List<DocModel> docs) {
        docs.forEach(doc -> {
            documentService.create(doc,
                    organizationService.getOrganization(organizationService.getInfPay(doc)),
                    organizationService.getOrganization(organizationService.getInfRcp(doc)),
                    bankService.setBank(bankService.getBankPay(doc)),
                    bankService.setBank(bankService.getBankRcp(doc)));
        });
    }

}
