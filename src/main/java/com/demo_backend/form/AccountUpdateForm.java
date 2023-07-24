package com.demo_backend.form;

import com.demo_backend.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountUpdateForm {
    private String password;
    private String firstName;
    private String lastName;
    private Account.Role role;
    private Integer departmentId;
}
