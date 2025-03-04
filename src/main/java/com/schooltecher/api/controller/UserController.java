package com.schooltecher.api.controller;

import com.schooltecher.api.dto.AuthDTO;
import com.schooltecher.api.model.Users;
import com.schooltecher.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthDTO login(@RequestBody Users user) {
        return new AuthDTO(userService.verify(user));
    }

//    TODO: verify endpoint
}
