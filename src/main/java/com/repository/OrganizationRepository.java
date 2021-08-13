package com.repository;

import com.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    boolean existsOrganizationByInn(String Inn);

    Organization findByInn(String inn);

    boolean existsOrganizationByKpp(String kpp);

    Organization findByCname(String name);

    boolean existsOrganizationByCname(String cname);

    Organization findById(long id);
}
