package com.niit.Authentication.service;

import com.niit.Authentication.domain.User;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user) {



        String jwttoken = Jwts.builder()
                .setSubject(user.getEmailid())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();

        Map<String,String> map = new HashMap<>();
        map.put("token",jwttoken);
        map.put("message","User successfully logged in");
        map.put("currentemailid",user.getEmailid());

        return map;
    }
}
