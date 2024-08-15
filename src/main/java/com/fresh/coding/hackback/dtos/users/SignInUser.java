package com.fresh.coding.hackback.dtos.users;


import java.io.Serializable;

public final class SignInUser extends UserBase implements Serializable {
    public SignInUser(String email, String password) {
        super(email, password);
    }
}
