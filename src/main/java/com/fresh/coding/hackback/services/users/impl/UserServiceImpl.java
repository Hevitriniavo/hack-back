package com.fresh.coding.hackback.services.users.impl;

import com.fresh.coding.hackback.repositories.RepositoryFactory;
import com.fresh.coding.hackback.services.users.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final RepositoryFactory repository;


    @Override
    @SneakyThrows(UsernameNotFoundException.class)
    public UserDetails loadUserByUsername(String username) {
        var user = repository.getUserRepository().findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );
    }

}
