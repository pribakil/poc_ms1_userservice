package com.bakil.microservice1.userservice.service;

import com.bakil.microservice1.userservice.domain.Department;
import com.bakil.microservice1.userservice.domain.User;
import com.bakil.microservice1.userservice.domain.UserDto;
import com.bakil.microservice1.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return userRepository.save( user );
    }

    public UserDto getUserById(String id) {
        UserDto finalUser =  new UserDto();

        User user = userRepository.findById(id).get();

        String uri = "http://DEPARTMENT-SERVICE/departments/code/"+user.getDepartmentCode();
        Department department = restTemplate.getForObject( uri, Department.class );
        finalUser.setUser(user);
        finalUser.setDepartment(department);

        return finalUser;
    }
}
