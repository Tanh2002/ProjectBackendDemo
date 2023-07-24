package com.demo_backend.dto;

import com.demo_backend.controller.AccountController;
import com.demo_backend.entity.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class AccountDto extends RepresentationModel<AccountDto> {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private Account.Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String departmentName;

    public AccountDto withSelfRel() {
        Link link = linkTo(methodOn(AccountController.class).findById(id)).withSelfRel();
        return add(link);
    }
}
