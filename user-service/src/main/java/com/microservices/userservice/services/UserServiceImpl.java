package com.microservices.userservice.services;

import com.microservices.userservice.VO.Department;
import com.microservices.userservice.VO.ResponseTemplateVO;
import com.microservices.userservice.entities.User;
import com.microservices.userservice.exceptions.UserNotFoundException;
import com.microservices.userservice.repositories.UserRepository;
import com.microservices.userservice.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findUserById(String id) {
        return this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(String id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        Department department = restTemplate.getForObject("http:/localhost:9001/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
