package com.demo_backend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "account")
@DynamicInsert
@DynamicUpdate
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false, updatable = false, length = 16)
    private String username;

    @Column(name = "password", nullable = false, length = 72)
    private String password;

    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;

    @Formula(value = "concat(first_name, ' ', last_name)")
    private String fullName;

    @Column(name = "role", nullable = false, length = 8)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    public enum Role {
        ADMIN, MANAGER, EMPLOYEE
    }
}
