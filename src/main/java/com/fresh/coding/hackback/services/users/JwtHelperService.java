package com.fresh.coding.hackback.services.users;


import com.fresh.coding.hackback.dtos.token.AuthToken;
import com.fresh.coding.hackback.entities.User;
import io.jsonwebtoken.Claims;

import java.util.function.Function;

public interface JwtHelperService {
    AuthToken generateToken(User user);

    boolean isValid(String token, User user);

    <T> T extractClaim(String token, Function<Claims, T> fn);

    String extractUsername(String token);
}
