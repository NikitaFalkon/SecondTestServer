package com.service.impl;

import com.entity.Organization;
import com.model.DocModel;
import com.model.Result;
import com.repository.OrganizationCrudRepository;
import com.repository.OrganizationRepository;
import com.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    OrganizationCrudRepository organizationCrudRepository;

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
    public List<Result> getFullResult() {
        return organizationCrudRepository.getAll();
    }

    @Override
    public Organization getInfPay(DocModel docModel) {
        Organization organization = new Organization();
        organization.setInn(docModel.getInn_Pay());
        organization.setCname(docModel.getcName_Pay());
        organization.setKpp(docModel.getKpp_Pay());

        return organization;
    }

    @Override
    public Organization getInfRcp(DocModel docModel) {
        Organization organization = new Organization();
        organization.setInn(docModel.getInn_Rcp());
        organization.setCname(docModel.getcName_Rcp());
        organization.setKpp(docModel.getKpp_Rcp());

        return organization;
    }

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public List<Result> getResultById(long id) {
        return organizationCrudRepository.getById(id);
    }

    @Override
    public List<Result> getResultByName(String name) {
        return organizationCrudRepository.getByCname(name);
    }
}
