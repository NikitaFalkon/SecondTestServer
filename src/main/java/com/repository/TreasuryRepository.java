package com.repository;

import com.entity.Treasury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreasuryRepository extends JpaRepository<Treasury, Long> {
    boolean existsTreasuryByAcc(String acc);

    Treasury findByAcc(String acc);
}
