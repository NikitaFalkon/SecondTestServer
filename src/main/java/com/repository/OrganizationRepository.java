package com.repository;

import com.entity.Organization;
import com.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    boolean existsOrganizationByInn(String Inn);

    Organization findByInn(String inn);

    boolean existsOrganizationByKpp(String kpp);

    Organization findByCname(String name);

    boolean existsOrganizationByCname(String cname);

    Organization findById(long id);

    @Query("SELECT new com.model.Result(c.cname, SUM (CASE WHEN b.payerOrganization.id =c.id and b.exist = true THEN 1 ELSE 0 END ), " +
            "SUM (CASE WHEN b.recipientOrganization.id =c.id and b.exist = true THEN 1 ELSE 0 END ))\n" +
            "FROM Organization c INNER JOIN Document b on (b.payerOrganization.id = c.id or b.recipientOrganization.id = c.id) GROUP BY c.cname")
    List<Result> getAll();

    @Query("SELECT new com.model.Result(c.cname, SUM (CASE WHEN b.payerOrganization.id =c.id and b.exist = true  THEN 1 ELSE 0 END ), " +
            "SUM (CASE WHEN b.recipientOrganization.id =c.id and b.exist = true  THEN 1 ELSE 0 END ))\n" +
            "FROM Organization c INNER JOIN Document b on (b.payerOrganization.id = c.id or b.recipientOrganization.id = c.id) and c.id = ?1 GROUP BY c.cname")
    List<Result> getById(long id);

    @Query("SELECT new com.model.Result(c.cname, SUM (CASE WHEN b.payerOrganization.id =c.id  and b.exist = true THEN 1 ELSE 0 END ), " +
            "SUM (CASE WHEN b.recipientOrganization.id =c.id and b.exist = true  THEN 1 ELSE 0 END ))\n" +
            "FROM Organization c INNER JOIN Document b on (b.payerOrganization.id = c.id or b.recipientOrganization.id = c.id) and c.cname = ?1 GROUP BY c.cname")
    List<Result> getByCname(String cname);

    @Override
    @Query("SELECT  e FROM Organization e WHERE e.exist=true ")
    List<Organization> findAll();
}
