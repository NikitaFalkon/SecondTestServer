package com.controller;

import com.model.DocModel;
import com.service.TableCreator;
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
    TableCreator tableCreator;

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ResponseEntity<String> createReport(@RequestBody List<DocModel> docModelList) {
        String response = docModelList.toString();
        tableCreator.create(docModelList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
