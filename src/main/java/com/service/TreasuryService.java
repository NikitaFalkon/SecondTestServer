package com.service;

import com.entity.Treasury;
import org.springframework.cache.annotation.Cacheable;

public interface TreasuryService {
    @Cacheable(cacheNames = "account")
    Treasury create(String account);

    void delete(long id);
}
