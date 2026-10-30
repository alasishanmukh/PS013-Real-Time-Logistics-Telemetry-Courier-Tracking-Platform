package com.klu.service;

import com.klu.dto.LoginRequest;
import com.klu.dto.RegisterRequest;
import com.klu.entity.User;

public interface AuthService {

    User register(RegisterRequest request);

    String login(LoginRequest request);
}