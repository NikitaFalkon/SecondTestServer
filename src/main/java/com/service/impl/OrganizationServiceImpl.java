package com.service.impl;

import com.entity.Organization;
import com.model.DocModel;
import com.model.Result;
import com.repository.OrganizationRepository;
import com.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @CachePut(cacheNames="organization")
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
        return isExist(results);
    }

    @Override
    @CachePut(cacheNames="organization")
    public Organization getInfPay(DocModel docModel) {
        Organization organization = new Organization();
        organization.setInn(docModel.getInn_Pay());
        organization.setCname(docModel.getcName_Pay());
        organization.setKpp(docModel.getKpp_Pay());

        return organization;
    }

    @Override
    @CachePut(cacheNames="organization")
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
        return isExist(organizationRepository.getById(id));
    }

    @Override
    @Cacheable(cacheNames = "name")
    public List<Result> getResultByName(String name) {
        return isExist(organizationRepository.getByCname(name));
    }

    @Override
    public void delete(long id) {
        Organization organization1 = organizationRepository.findById(id);
        if(organization1 != null) {
            organization1.setExist(false);
            organizationRepository.save(organization1);
        }

    }

    @Override
    public List<Result> isExist(List<Result> results) {
        if (results.size()==0) {
            return results;
        }

        List<Result> results2 = new ArrayList<>();
        for (Result result : results) {
            Organization organization = organizationRepository.findByCname(result.getName());
            if (organization.isExist()) {
                results2.add(result);
            }
        }
        return results2;
    }
}
