package com.demo_backend.service;

import com.demo_backend.dto.DepartmentDto;
import com.demo_backend.form.DepartmentCreateForm;
import com.demo_backend.form.DepartmentFilterForm;
import com.demo_backend.form.DepartmentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<DepartmentDto> findAll(DepartmentFilterForm form, Pageable pageable);

    DepartmentDto findById(Integer id);

    void create(DepartmentCreateForm form);

    void update(Integer id, DepartmentUpdateForm form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
