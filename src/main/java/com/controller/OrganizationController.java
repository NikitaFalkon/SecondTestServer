package com.controller;

import com.model.Result;
import com.repository.DocumentRepository;
import com.service.JsonService;
import com.service.OrganizationService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;
    @Autowired
    JsonService jsonService;

    @GetMapping("/organizations")
    public List<Result> getOrganizations() {
        return organizationService.getFullResult();
    }

    @GetMapping("/organizationId/{id}")
    public Result getOrganizationById(@PathVariable(name = "id") long id) throws JSONException, IOException {
        List<Result> results = organizationService.getResultById(id);
        return  results.get(0);
    }

    @GetMapping("/organizationName/{name}")
    public Result getOrganizationByName(@PathVariable(name = "name") String name) throws JSONException {
        List<Result> results = organizationService.getResultByName(name);
        return results.get(0);
    }

    private String getResults(String results) throws JSONException {
        if(results.isEmpty())
        {
            return "No such organization";
        }

        return results.toString();
    }
}
