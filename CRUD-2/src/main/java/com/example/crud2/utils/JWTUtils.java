package com.example.crud2.utils;

import com.example.crud2.decorater.JwtUserDecorator;
import com.example.crud2.enums.Roles;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.*;

public class JWTUtils {
    public static final String SECRET_KEY = "secretkey";

    public static JwtUserDecorator getTokenData(String token)
    {
        JwtUserDecorator jwtUserDecorator = new JwtUserDecorator();
        Claims claims = decodeJwtToken(token);
        Set<Roles> roles = new HashSet<>((Collection) claims.get("userRoles"));
        jwtUserDecorator.setId((String) claims.get("id"));
        //jwtUserDecorator.setUserRoles(roles);
        return jwtUserDecorator;
    }

    public String generateToken(String id, Set<Roles> userRoles) {
        Claims claims = Jwts.claims();
        claims.put("id", id);
        claims.put("userRoles", userRoles);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (10 * 60 * 1000)))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Claims decodeJwtToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }


    /*public static User (String token) {

        Claims claims = Jwts.claims();
        claims.get("id");
        User user =
    }*/

}