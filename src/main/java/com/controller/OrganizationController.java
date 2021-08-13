package com.controller;

import com.entity.Organization;
import com.model.Result;
import com.repository.DocumentGrudRepository;
import com.service.OrganizationService;
import com.service.impl.JsonServiceImpl;
import org.json.JSONException;
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
    JsonServiceImpl organizationToJson;
    @Autowired
    DocumentGrudRepository documentGrudRepository;

    @GetMapping("/organizations")
    public String getOrganizations() {
        return organizationService.getFullResult().toString();
    }

    @GetMapping("/organizationId/{id}")
    public String getOrganizationById(@PathVariable(name = "id") long id) throws JSONException {
        List<Result> results = organizationService.getResultById(id);
        return getResults(results);
    }

    @GetMapping("/organizationName/{name}")
    public String getOrganizationByName(@PathVariable(name = "name") String name) throws JSONException {
        List<Result> results = organizationService.getResultByName(name);
        return getResults(results);
    }

    private String getResults(List<Result> results) throws JSONException {
        if(results.size()==0)
        {
            return "No such organization";
        }

        return results.toString();
    }
}
