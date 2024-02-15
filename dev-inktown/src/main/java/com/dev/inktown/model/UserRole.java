package com.dev.inktown.model;


import lombok.Getter;

@Getter
public enum UserRole {
    EMP(0),
    CUST(1);
    private final int internalId;
    UserRole(int internalId){
        this.internalId = internalId;
    }
}
