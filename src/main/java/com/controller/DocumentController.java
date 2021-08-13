package com.controller;

import com.service.ApacheService;
import com.service.DocumentService;
import com.service.JsonService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class DocumentController {
    @Autowired
    DocumentService documentService;
    @Autowired
    JsonService jsonService;
    @Autowired
    ApacheService apacheService;

    @GetMapping("/documentsum")
    public String sum(Model model) throws JSONException {
        return jsonService.documentsToJson().toString();
    }

    @GetMapping(value = "/createpoi")
    public String createPoi() throws IOException {
        File file = new File("Documents.xls");
        apacheService.createNewDoc(file, documentService.findAll());

        return "done!";
    }

}
