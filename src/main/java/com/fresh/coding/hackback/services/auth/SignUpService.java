package com.fresh.coding.hackback.services.auth;

import com.fresh.coding.hackback.dtos.token.AuthToken;
import com.fresh.coding.hackback.dtos.users.CreateUser;
import lombok.NonNull;

@FunctionalInterface
public interface SignUpService {
    AuthToken signUp(@NonNull CreateUser user);
}
