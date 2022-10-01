package com.microservices.userservice.services;

import com.microservices.userservice.entities.User;
import com.microservices.userservice.exceptions.UserNotFoundException;
import com.microservices.userservice.repositories.UserRepository;
import com.microservices.userservice.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findUserById(String id) {
        return this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
