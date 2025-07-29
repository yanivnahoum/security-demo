package com.att.training.security.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }
}
