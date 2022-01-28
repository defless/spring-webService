package com.cours.spring.services;

import com.cours.spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cours.spring.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createOrUpdate(User user) {
        return userRepository.save(user);
    }
    public User getUserById(String username) {
        return userRepository.findById(username).orElse(null);
    }

}
