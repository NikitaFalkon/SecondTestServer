package com.controller;

import com.entity.Document;
import com.service.ApacheService;
import com.service.DocumentService;
import com.service.JsonService;
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
    DocumentService documentService;
    @Autowired
    JsonService jsonService;
    @Autowired
    ApacheService apacheService;

    @GetMapping("/documents")
    public String sum(Model model) throws JSONException {
        List<Document> documentList = documentService.findAll();
        JSONObject obj = new JSONObject();
        obj.put("documents", documentList.size());
        obj.put("sum", documentService.getAverageSum());
        return obj.toString();
    }

    @GetMapping(value = "/createpoi")
    public String createPoi() throws IOException {
        File file = new File("Documents.xls");
        apacheService.createNewDoc(file, documentService.findAll());

        return "done!";
    }

}
