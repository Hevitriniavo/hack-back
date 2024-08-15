package com.fresh.coding.hackback.services.auth.impl;

import com.fresh.coding.hackback.dtos.token.AuthToken;
import com.fresh.coding.hackback.dtos.users.CreateUser;
import com.fresh.coding.hackback.entities.Role;
import com.fresh.coding.hackback.entities.User;
import com.fresh.coding.hackback.enums.RoleName;
import com.fresh.coding.hackback.repositories.RepositoryFactory;
import com.fresh.coding.hackback.services.auth.SignUpService;
import com.fresh.coding.hackback.services.users.JwtHelperService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {
    private final RepositoryFactory repositoryFactory;
    private final PasswordEncoder passwordEncoder;
    private final JwtHelperService jwtHelperService;


    @Transactional
    @Override
    public AuthToken signUp(@NonNull CreateUser user) {
        var defaultRole = findOrCreateRole();
        var password = passwordEncoder.encode(user.getPassword());
        var newUser = User.builder()
                .email(user.getEmail())
                .password(password)
                .username(user.getUsername())
                .build();
        newUser.getRoles().add(defaultRole);
        var savedUser = repositoryFactory.getUserRepository().save(newUser);
        var authToken = jwtHelperService.generateToken(savedUser);
        savedUser.setToken(authToken.getToken());
        repositoryFactory.getUserRepository().save(savedUser);
        return authToken;
    }


    private Role findOrCreateRole() {
        var roleRepository = repositoryFactory.getRoleRepository();
        return roleRepository.findByName(RoleName.USER).orElseGet(() -> {
            var role = Role.builder()
                    .name(RoleName.USER)
                    .build();
            return roleRepository.saveAndFlush(role);
        });
    }


}
