package com.example.springsecurity.Service;

import com.example.springsecurity.Model.User;
import com.example.springsecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User createUser(User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }
}
