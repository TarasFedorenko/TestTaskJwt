package com.example.testtask.service;

import com.example.testtask.dao.request.SignInRequest;
import com.example.testtask.dao.request.SignUpRequest;
import com.example.testtask.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
