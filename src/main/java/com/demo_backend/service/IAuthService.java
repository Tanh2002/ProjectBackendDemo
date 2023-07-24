package com.demo_backend.service;

import com.demo_backend.form.AuthRegisterForm;
import com.demo_backend.form.AuthUpdateForm;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAuthService extends UserDetailsService {
    void create(AuthRegisterForm form);

    void update(String username, AuthUpdateForm form);
}
