package com.demo_backend.repository;

import com.demo_backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);
}
