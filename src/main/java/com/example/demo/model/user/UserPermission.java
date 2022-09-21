package com.example.demo.model.user;

public enum UserPermission {
    USER_BUY("user:buy"),
    ADMIN_BUY("admin:buy"),
    ADMIN_ADD_DISCOUNT("admin:add_discount"),
    ADMIN_ADD_PRODUCT("admin:add_product"),
    ADMIN_REMOVE_PRODUCT("admin:remove_product"),
    ADMIN_REMOVE_DISCOUNT("admin:remove_discount");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }


}
