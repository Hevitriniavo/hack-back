package com.fresh.coding.hackback.services.auth;

import com.fresh.coding.hackback.dtos.token.AuthToken;
import com.fresh.coding.hackback.dtos.users.SignInUser;
import lombok.NonNull;

@FunctionalInterface
public interface SignInService {
    @NonNull
    AuthToken signIn(@NonNull SignInUser user);
}

