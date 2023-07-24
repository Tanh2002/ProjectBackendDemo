package com.demo_backend.controller;

import com.demo_backend.dto.DepartmentDto;
import com.demo_backend.form.DepartmentCreateForm;
import com.demo_backend.form.DepartmentFilterForm;
import com.demo_backend.form.DepartmentUpdateForm;
import com.demo_backend.service.IDepartmentService;
import com.demo_backend.validation.DepartmentIdExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @GetMapping
    public Page<DepartmentDto> findAll(DepartmentFilterForm form, Pageable pageable) {
        return service.findAll(form, pageable);
    }

    @GetMapping("/{id}")
    public DepartmentDto findById(@PathVariable("id") @DepartmentIdExists Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public void create(@RequestBody @Valid DepartmentCreateForm form) {
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") @DepartmentIdExists Integer id, @RequestBody DepartmentUpdateForm form) {
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
