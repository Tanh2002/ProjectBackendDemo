package com.demo_backend.service;

import com.demo_backend.dto.AccountDto;
import com.demo_backend.form.AccountCreateForm;
import com.demo_backend.form.AccountFilterForm;
import com.demo_backend.form.AccountUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<AccountDto> findAll(AccountFilterForm form, Pageable pageable);

    AccountDto findById(Integer id);

    void create(AccountCreateForm form);

    void update(Integer id, AccountUpdateForm form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
