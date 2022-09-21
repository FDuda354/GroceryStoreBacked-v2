package com.example.demo.model.user;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.model.user.UserPermission.*;

public enum UserRole {
    USER(Sets.newHashSet(USER_BUY)),
    ADMIN(Sets.newHashSet(ADMIN_BUY, ADMIN_ADD_DISCOUNT, ADMIN_ADD_PRODUCT, ADMIN_REMOVE_PRODUCT, ADMIN_REMOVE_DISCOUNT));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

}
