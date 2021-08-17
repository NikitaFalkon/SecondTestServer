package com.service.impl;

import com.entity.Document;
import com.entity.Organization;
import com.model.DocModel;
import com.model.Result;
import com.repository.OrganizationRepository;
import com.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public Organization create(Organization organization) {
        organizationRepository.save(organization);

        return organization;
    }

    @Override
    public Organization getOrganization(Organization organization) {
        if (!organizationRepository.existsOrganizationByInn(organization.getInn()) &&
                !organizationRepository.existsOrganizationByKpp(organization.getKpp())) {
            if (!organizationRepository.existsOrganizationByCname(organization.getCname())) {
                return create(organization);
            } else {
                return organizationRepository.findByCname(organization.getCname());
            }
        } else {
            return organizationRepository.findByInn(organization.getInn());
        }
    }
    @Override
    @Cacheable(cacheNames = "results")
    public List<Result> getFullResult() {
        List<Result> results = organizationRepository.getAll();
        return results;
    }

    @Override
    @Cacheable(cacheNames = "docModel")
    public Organization getInfPay(DocModel docModel) {
        Organization organization = new Organization();
        organization.setInn(docModel.getInn_Pay());
        organization.setCname(docModel.getcName_Pay());
        organization.setKpp(docModel.getKpp_Pay());

        return organization;
    }

    @Override
    @Cacheable(cacheNames = "docModel")
    public Organization getInfRcp(DocModel docModel) {
        Organization organization = new Organization();
        organization.setInn(docModel.getInn_Rcp());
        organization.setCname(docModel.getcName_Rcp());
        organization.setKpp(docModel.getKpp_Rcp());

        return organization;
    }

    @Override
    @Cacheable(cacheNames = "organizations")
    public List<Organization> findAll() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizations;
    }

    @Override
    @Cacheable(cacheNames = "id")
    public List<Result> getResultById(long id) {
        return organizationRepository.getById(id);
    }

    @Override
    @Cacheable(cacheNames = "name")
    public List<Result> getResultByName(String name) {
        return organizationRepository.getByCname(name);
    }
}
