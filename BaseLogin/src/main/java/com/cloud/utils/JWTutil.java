package com.cloud.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTutil {
    public static String createToken(String username){
        Map<String,Object> claims=new HashMap<>();
        claims.put("username",username);
        String token = Jwts.builder()
                             .setClaims(claims)
                             .signWith(SignatureAlgorithm.HS256, "Benson")
                             .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                             .compact();
        return token;
    }
}
