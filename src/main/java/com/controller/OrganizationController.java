package com.controller;

import com.entity.Organization;
import com.repository.OrganizationRepository;
import com.service.JsonServiceImpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganizationController {
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    JsonServiceImpl organizationToJson;

    @GetMapping("/organizations")
    public String getOrganiztions() {
        List<Organization> organizations = organizationRepository.findAll();

        return organizationToJson.toJsonList(organizations).toString();
    }

    @GetMapping("/organizationId/{id}")
    public String getOrganiztionById(@PathVariable(name = "id") long id) throws JSONException {
        Organization organization = organizationRepository.findById(id).orElseThrow();

        return  getOrganization(organization);
    }

    @GetMapping("/organizationName/{name}")
    public String getOrganiztionByName(@PathVariable(name = "name") String name) throws JSONException {
        Organization organization = organizationRepository.findByCname(name);

        return  getOrganization(organization);
    }

    private String getOrganization(Organization organization) throws JSONException {
        if(organization == null)
        {
            return "No such organization";
        }

        return organizationToJson.newJsonObject(organization).toString();
    }
}
