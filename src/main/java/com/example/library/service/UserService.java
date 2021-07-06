package com.example.library.service;

import com.example.library.Repository.UserRepo;
import com.example.library.model.dto.UserDto;
import com.example.library.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Page<User> show(Pageable pageable) {
        Page<User> users = userRepo.findAll(pageable);
        return users;
    }

    public User update(Long id, UserDto userDto) {
        User user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDto.getName());
            user.setCodeMeli(userDto.getCodeMeli());
            user.setRole(userDto.getRole());
            return userRepo.save(user);
        }
        return null;
    }

    public User add(UserDto userDto) {
        User user = new User();
        user.setRole(userDto.getRole());
        if(userDto.getRole()==1) {
            user.setName(userDto.getName());
            user.setCodeMeli(userDto.getCodeMeli());
            return userRepo.save(user);
        }
        return null;
    }
}
