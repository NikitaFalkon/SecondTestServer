package com.service;

import com.entity.Organization;
import com.model.DocModel;

import java.util.List;

public interface OrganizationService {
    Organization create(Organization organization);

    Organization getOrganization(Organization organization);

    Organization getInfPay(DocModel docModel);

    Organization getInfRcp(DocModel docModel);

    List<Organization> findAll();

    Organization findOrganizationdById(long id);

    Organization findByCname(String name);
}
