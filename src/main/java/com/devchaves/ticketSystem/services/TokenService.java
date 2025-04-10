package com.devchaves.ticketSystem.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.devchaves.ticketSystem.util.Util;
import com.devchaves.ticketSystem.models.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private final Util util;

    public TokenService(Util util) {
        this.util = util;
    }

    public String generateToken(UserModel user) {
        try {

            if(user == null || user.getUsersName() == null) {
                throw new IllegalArgumentException("User or username cannot be null");
            }

            Algorithm algorithm = Algorithm.HMAC256(secret);

            Date experationDate = Date.from(util.generationExpirationDate());

            String token = JWT.create()
                    .withSubject(user.getUsersName())
                    .withIssuer("TicketSystem")
                    .withExpiresAt(experationDate)
                    .sign(algorithm);

            return token;

        } catch (Exception e) {
            throw new RuntimeException("Error generating token", e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWT.require(algorithm)
                    .withIssuer("TicketSystem")
                    .build()
                    .verify(token)
                    .getSubject();

            return "Token is valid";

        } catch (JWTVerificationException e) {
            return null;
        }
    }

    public Date getDateExperation(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Date expirationDate = JWT.require(algorithm)
                    .withIssuer("TicketSystem")
                    .build()
                    .verify(token)
                    .getExpiresAt();

            return expirationDate;

        } catch (JWTVerificationException e) {
            return null;
        }
    }

}
