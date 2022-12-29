package com.niit.Authentication.service;

import com.niit.Authentication.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String, String> generateToken(User user);
}
