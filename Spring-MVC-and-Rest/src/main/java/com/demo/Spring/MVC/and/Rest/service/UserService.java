package com.demo.Spring.MVC.and.Rest.service;

import java.util.Map;
import java.util.List;
import org.slf4j.Logger;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.demo.Spring.MVC.and.Rest.model.User;
import com.demo.Spring.MVC.and.Rest.dto.UserRequest;


@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final Map<Long, User> users;
    private final IDService idService;

    UserService(IDService idService) {
        this.idService = idService;
        this.users = new HashMap<>();
    }

    public List<UserRequest> getAllUsers() {

        return users.values().stream()
                .map(UserRequest::fromUser)
                .collect(Collectors.toList());
    }

    public UserRequest getUser(Long id) {
        if (!users.containsKey(id)) {
            return null;
        }

        return UserRequest.fromUser(users.get(id));
    }

    public UserRequest createUser(UserRequest userRequest) {
        long id = idService.getIdGenerator();
        User user = new User();
        user.setId(id);
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setId(id);
        users.put(user.getId(), user);
        logger.info("Username: {} id: {} Time Created: {}", user.getName(), id, LocalDateTime.now());

        return userRequest;
    }

    public UserRequest updateUser(Long id, UserRequest userRequest) {
        if (!users.containsKey(id)) {
            return null;
        }
        User user = users.get(id);
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        users.put(user.getId(), user);
        logger.info("Username: {} id: {} Time Updated: {}", user.getName(), id, LocalDateTime.now());

        return userRequest;
    }

    public Boolean deleteUser(Long id) {
        if (!users.containsKey(id)) {
            return false;
        }
        users.remove(id);
        logger.info("Username: {} id: {} Time Deleted", id, LocalDateTime.now());

        return true;
    }

}
