package com.demo_backend.controller;

import com.demo_backend.dto.AccountDto;
import com.demo_backend.form.AccountCreateForm;
import com.demo_backend.form.AccountFilterForm;
import com.demo_backend.form.AccountUpdateForm;
import com.demo_backend.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @GetMapping
    public Page<AccountDto> findAll(AccountFilterForm form, Pageable pageable) {
        return service.findAll(form, pageable);
    }

    @GetMapping("/{id}")
    public AccountDto findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public void create(@RequestBody AccountCreateForm form) {
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody AccountUpdateForm form) {
        service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllById(@RequestBody List<Integer> ids) {
        service.deleteAllById(ids);
    }
}
