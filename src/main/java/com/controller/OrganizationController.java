package com.controller;

import com.model.Result;
import com.repository.OrganizationRepository;
import com.service.OrganizationService;
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
    OrganizationRepository organizationRepository;

    @GetMapping("/organizations")
    public List<Result> getOrganizations() {
        return check(organizationService.getFullResult());
    }

    @GetMapping("/organizationId/{id}")
    public List<Result> getOrganizationById(@PathVariable(name = "id") long id) {
        List<Result> results = organizationService.getResultById(id);
        return check(results);
    }

    @GetMapping("/organizationName/{name}")
    public List<Result> getOrganizationByName(@PathVariable(name = "name") String name) {
        List<Result> results = organizationService.getResultByName(name);
        return check(results);
    }

    @GetMapping("/organizationdelete/{id}")
    public List<Result> deleteOrganizationById(@PathVariable(name = "id") long id) {
        organizationService.delete(id);
        return organizationService.getFullResult();
    }

    private List<Result> check(List<Result> results) {
        if(results.isEmpty())
        {
           return null;
        }

        return results;
    }
}
