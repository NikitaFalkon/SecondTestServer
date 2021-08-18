package com.controller;

import com.entity.Document;
import com.model.Result;
import com.repository.DocumentRepository;
import com.service.ApacheService;
import com.service.DocumentService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class DocumentController {
    @Autowired
    DocumentService documentService;
    @Autowired
    ApacheService apacheService;
    @Autowired
    DocumentRepository documentRepository;

    @GetMapping("/documents")
    public String sum(Model model) throws JSONException {
        List<Document> documentList = documentService.findAll();
        JSONObject obj = new JSONObject();
        obj.put("documents", documentList.size());
        obj.put("sum", documentService.getAverageSum());
        return obj.toString();
    }

    @GetMapping("/documentdelete/{id}")
    public ModelAndView deleteOrganizationById(@PathVariable(name = "id") long id) {
        documentService.delete(id);
        return new ModelAndView(new RedirectView("/documents", true));
    }

    @GetMapping(value = "/createpoi")
    public String createPoi() throws IOException {
        File file = new File("Documents.xls");
        apacheService.createNewDoc(file, documentService.findAll());

        return "done!";
    }

}
