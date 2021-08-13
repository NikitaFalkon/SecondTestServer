package com.service;

import com.entity.Organization;
import com.model.DocModel;
import com.model.Result;

import java.util.List;

public interface OrganizationService {
    Organization create(Organization organization);

    Organization getOrganization(Organization organization);

    Organization getInfPay(DocModel docModel);

    Organization getInfRcp(DocModel docModel);

    List<Organization> findAll();

    List<Result> getFullResult();

    List<Result> getResultById(long id);

    List<Result> getResultByName(String name);
}
