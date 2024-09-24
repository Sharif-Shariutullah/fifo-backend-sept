package com.example.fifotech.services.auth;

import com.example.fifotech.dto.SignupRequest;
import com.example.fifotech.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);
    Boolean hasUserWithEmail(String email);
}
