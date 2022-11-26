package com.erp.Coffee.service;

import com.erp.Coffee.model.Role;
import com.erp.Coffee.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
