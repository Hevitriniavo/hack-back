package com.fresh.coding.hackback.controllers;

import com.fresh.coding.hackback.dtos.token.AuthToken;
import com.fresh.coding.hackback.dtos.users.SignInUser;
import com.fresh.coding.hackback.services.auth.SignInService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/sign-in")
@RequiredArgsConstructor
public class SignInController {
    private final SignInService signInService;

    @PostMapping
    public AuthToken signIn(@RequestBody @Valid SignInUser user) {
        return signInService.signIn(user);
    }
}
