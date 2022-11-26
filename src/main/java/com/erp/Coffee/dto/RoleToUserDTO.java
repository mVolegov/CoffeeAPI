package com.erp.Coffee.dto;

import java.util.Objects;

public class RoleToUserDTO {

    private String username;
    private String role;

    public RoleToUserDTO() {}

    public RoleToUserDTO(String username, String role) {
        this.username = username;
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleToUserDTO{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleToUserDTO that = (RoleToUserDTO) o;
        return Objects.equals(username, that.username) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
