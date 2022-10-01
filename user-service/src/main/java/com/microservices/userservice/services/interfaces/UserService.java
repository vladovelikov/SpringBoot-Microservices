package com.microservices.userservice.services.interfaces;

import com.microservices.userservice.entities.User;

public interface UserService {
    User saveUser(User user);

    User findUserById(String id);
}
