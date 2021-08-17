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

import java.util.List;

@RestController
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;
    @Autowired
    JsonService jsonService;

    @GetMapping("/organizations")
    public String getOrganizations() {
        return organizationService.getFullResult().toString();
    }

    /*@GetMapping("/organizationId/{id}")
    public String getOrganizationById(@PathVariable(name = "id") long id) throws JSONException {
        List<Result> results = organizationService.getResultById(id);
        return getResults(jsonService.newJsonObject(results.get(0)));
    }*/

    @GetMapping("/organizationId/{id}")
    public JSONObject getOrganizationById(@PathVariable(name = "id") long id) throws JSONException {
        List<Result> results = organizationService.getResultById(id);
        return  jsonService.newJsonObject(results.get(0));
    }

 /*   @GetMapping("/organizationName/{name}")
    public String getOrganizationByName(@PathVariable(name = "name") String name) throws JSONException {
        List<Result> results = organizationService.getResultByName(name);
        return getResults(jsonService.newJsonObject(results.get(0)));
    }*/

    private String getResults(String results) throws JSONException {
        if(results.isEmpty())
        {
            return "No such organization";
        }

        return results.toString();
    }
}
