package com.demo_backend.service;

import com.demo_backend.dto.DepartmentDto;
import com.demo_backend.entity.Account;
import com.demo_backend.entity.Department;
import com.demo_backend.form.DepartmentCreateForm;
import com.demo_backend.form.DepartmentFilterForm;
import com.demo_backend.form.DepartmentUpdateForm;
import com.demo_backend.repository.IDepartmentRepository;
import com.demo_backend.specification.DepartmentSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    private final IDepartmentRepository repository;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;

    @Autowired
    public DepartmentService(IDepartmentRepository repository, ModelMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public Page<DepartmentDto> findAll(DepartmentFilterForm form, Pageable pageable) {
        Specification<Department> spec = DepartmentSpecification.buildSpec(form);
        return repository.findAll(spec, pageable)
                .map(department -> mapper.map(department, DepartmentDto.class).withSelfRel());
    }

    @Override
    public DepartmentDto findById(Integer id) {
        return repository.findById(id)
                .map(department -> mapper.map(department, DepartmentDto.class))
                .orElse(null);
    }

    @Override
    @Transactional
    public void create(DepartmentCreateForm form) {
        Department department = mapper.map(form, Department.class);
        List<Account> accounts = department.getAccounts();
        if (accounts != null) {
            for (Account account : accounts) {
                String encodedPassword = encoder.encode(account.getPassword());
                account.setPassword(encodedPassword);
                account.setDepartment(department);
            }
        }
        repository.save(department);
    }

    @Override
    public void update(Integer id, DepartmentUpdateForm form) {
        Department department = mapper.map(form, Department.class);
        department.setId(id);
        repository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);
    }
}
