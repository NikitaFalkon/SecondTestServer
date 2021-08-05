package com.controller;

import com.entity.Document;
import com.repository.DocumentRepository;
import com.service.ApacheServiceImpl;
import com.service.DocumentServiceImpl;
import com.service.JsonServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    DocumentServiceImpl documentService;
    @Autowired
    JsonServiceImpl jsonService;
    @Autowired
    ApacheServiceImpl apacheService;

    @GetMapping("/document")
    public String allDocuments(Model model) throws JSONException {
        List<Document> documentList = documentRepository.findAll();
        JSONObject object = jsonService.documentsToJson(documentList, documentService.findSum(documentList));

        return object.toString();
    }

    @GetMapping(value = "/createpoi")
    public String createPoi() throws IOException {
        File file = new File("Documents.xls");
        apacheService.createNewDoc(file, documentRepository.findAll());

        return "done!";
    }

}
