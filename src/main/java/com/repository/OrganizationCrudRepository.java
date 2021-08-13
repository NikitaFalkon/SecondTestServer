package com.repository;

import com.entity.Organization;
import com.model.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrganizationCrudRepository extends CrudRepository<Organization, Long> {
    @Query("SELECT new com.model.Result(c.cname, SUM (CASE WHEN b.payerOrganization.id =c.id THEN 1 ELSE 0 END ), " +
            "SUM (CASE WHEN b.recipientOrganization.id =c.id THEN 1 ELSE 0 END ))\n" +
            "FROM Organization c INNER JOIN Document b on b.payerOrganization.id = c.id or b.recipientOrganization.id = c.id GROUP BY c.cname")
    List<Result> getAll();

    @Query("SELECT new com.model.Result(c.cname, SUM (CASE WHEN b.payerOrganization.id =c.id THEN 1 ELSE 0 END ), " +
            "SUM (CASE WHEN b.recipientOrganization.id =c.id THEN 1 ELSE 0 END ))\n" +
            "FROM Organization c INNER JOIN Document b on (b.payerOrganization.id = c.id or b.recipientOrganization.id = c.id) and c.id = ?1 GROUP BY c.cname")
    List<Result> getById(long id);

    @Query("SELECT new com.model.Result(c.cname, SUM (CASE WHEN b.payerOrganization.id =c.id THEN 1 ELSE 0 END ), " +
            "SUM (CASE WHEN b.recipientOrganization.id =c.id THEN 1 ELSE 0 END ))\n" +
            "FROM Organization c INNER JOIN Document b on (b.payerOrganization.id = c.id or b.recipientOrganization.id = c.id) and c.cname = ?1 GROUP BY c.cname")
    List<Result> getByCname(String cname);
}