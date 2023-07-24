package com.demo_backend.validation;

import com.demo_backend.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentIdExistsValidator implements
        ConstraintValidator<DepartmentIdExists, Integer> {
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext context) {
        return repository.existsById(id);
    }
}