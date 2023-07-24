package com.demo_backend.form;

import com.demo_backend.entity.Department;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class DepartmentFilterForm {
    private String search;
    private Department.Type type;
    private Integer minTotalMembers;
    private Integer maxTotalMembers;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate minCreatedDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate maxCreatedDate;
}
