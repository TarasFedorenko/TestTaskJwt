package com.example.testtask.service;

import com.example.testtask.data.request.SignInRequest;
import com.example.testtask.data.request.SignUpRequest;
import com.example.testtask.data.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
