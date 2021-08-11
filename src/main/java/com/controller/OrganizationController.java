package com.controller;

import com.entity.Organization;
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

    /*@GetMapping("/organizations")
    public String getOrganiztions() {
        List<Organization> organizations = organizationService.findAll();

        return organizationToJson.toJsonList(organizations).toString();
    }*/

    /*@GetMapping("/organizationId/{id}")
    public String getOrganiztionById(@PathVariable(name = "id") long id) throws JSONException {
        Organization organization = organizationService.findOrganizationdById(id);

        return  getOrganization(organization);
    }*/

    /*@GetMapping("/organizationName/{name}")
    public String getOrganiztionByName(@PathVariable(name = "name") String name) throws JSONException {
        Organization organization = organizationService.findByCname(name);

        return  getOrganization(organization);
    }*/

    /*private String getOrganization(Organization organization) throws JSONException {
        if(organization == null)
        {
            return "No such organization";
        }

        return organizationToJson.newJsonObject(organization).toString();
    }*/
}
