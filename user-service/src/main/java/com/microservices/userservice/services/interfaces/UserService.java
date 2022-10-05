package com.microservices.userservice.services.interfaces;

import com.microservices.userservice.VO.ResponseTemplateVO;
import com.microservices.userservice.entities.User;

public interface UserService {
    User saveUser(User user);

    User findUserById(Long id);

    ResponseTemplateVO getUserWithDepartment(Long id);
}
