package com.service;

import com.entity.Organization;
import com.model.DocModel;
import com.model.Result;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface OrganizationService {
    Organization create(Organization organization);

    @Cacheable(cacheNames = "organization")
    Organization getOrganization(Organization organization);

    Organization getInfPay(DocModel docModel);

    Organization getInfRcp(DocModel docModel);

    List<Organization> findAll();

    List<Result> getFullResult();

    @Cacheable(cacheNames = "id")
    List<Result> getResultById(long id);

    @Cacheable(cacheNames = "name")
    List<Result> getResultByName(String name);
}
