package com.cloud.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTutil {
    public static Claims parse(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey("Benson")
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
        return claims;
    }
}
