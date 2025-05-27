package com.demo.Spring.MVC.and.Rest.service;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.demo.Spring.MVC.and.Rest.model.UserDto;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final Map<Long, UserDto> users;
    private final IDService idService;

    UserService(IDService idService) {
        this.idService = idService;
        this.users = new HashMap<>();
    }

    public List<UserDto> getAllUsers() {

        return new ArrayList<>(users.values());
    }

    public UserDto getUser(Long id) {
        return users.get(id);
    }

    public UserDto createUser(UserDto userDto) {
        long id = idService.getIdGenerator();
        userDto.id = id;
        users.put(id, userDto);
        return userDto;
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        if (!users.containsKey(id)) {
            return null;
        }
        userDto.id = id;
        users.put(id, userDto);
        return userDto;
    }

    public Boolean deleteUser(Long id) {
        if (!users.containsKey(id)) {
            return false;
        }
        users.remove(id);
        return true;
    }

}
