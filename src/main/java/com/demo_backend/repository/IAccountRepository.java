package com.demo_backend.repository;

import com.demo_backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountRepository extends
        JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
    boolean existsByUsername(String username);
}
