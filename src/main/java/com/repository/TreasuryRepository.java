package com.repository;

import com.entity.Treasury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;

@Repository
public interface TreasuryRepository extends JpaRepository<Treasury, Long> {
    //@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    boolean existsTreasuryByAcc(String acc);

    //@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    Treasury findByAcc(String acc);
}
