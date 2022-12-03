package com.erp.Coffee.restcontroller;

import com.erp.Coffee.model.Role;
import com.erp.Coffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleRestController {

    private final UserService userService;

    @Autowired
    public RoleRestController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    /**
     * Добавление новой роли
     */
    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity<>(userService.saveRole(role), HttpStatus.CREATED);
    }
}
