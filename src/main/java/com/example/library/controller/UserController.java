package com.example.library.controller;

import com.example.library.model.dto.UserDto;
import com.example.library.model.entity.User;
import com.example.library.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody UserDto userDto) {
        return userService.add(userDto);
    }

    @GetMapping("/update/{id}")
    public User update(@RequestBody UserDto userDto, @PathVariable Long id) {

        return userService.update(id, userDto);

    }

    @PostMapping("/show")

    public Page<User> show(Pageable pageable) {
        return userService.show(pageable);
    }
}
