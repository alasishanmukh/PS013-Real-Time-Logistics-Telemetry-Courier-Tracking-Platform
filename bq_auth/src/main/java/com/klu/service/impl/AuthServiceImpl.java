package com.klu.service.impl;

import org.springframework.stereotype.Service;

import com.klu.dto.LoginRequest;
import com.klu.dto.RegisterRequest;
import com.klu.entity.User;
import com.klu.repo.UserRepo;
import com.klu.service.AuthService;
import com.klu.util.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepo;

    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            UserRepo userRepo,
            JwtUtil jwtUtil) {

        this.userRepo = userRepo;

        this.jwtUtil = jwtUtil;
    }

    @Override
    public User register(RegisterRequest request) {

        if (userRepo.existsByEmail(request.getEmail())) {

            throw new RuntimeException(
                    "Email already registered"
            );
        }

        User user = new User();

        user.setName(request.getName());

        user.setEmail(request.getEmail());

        user.setPassword(request.getPassword());

        user.setRole("USER");

        return userRepo.save(user);
    }

    @Override
    public String login(LoginRequest request) {

        User user = userRepo
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        )
                );

        if (!user.getPassword()
                .equals(request.getPassword())) {

            throw new RuntimeException(
                    "Invalid password"
            );
        }

        return jwtUtil.generateToken(
                user.getEmail()
        );
    }
}