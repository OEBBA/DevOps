package com.example.userscrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.userscrud.entity.User;
import com.example.userscrud.exception.UserNotFoundException;
import com.example.userscrud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        User user = userRepository.findByEmailAddress(email);
        if (user == null) {
            throw new UserNotFoundException("User with email: " + email + " doesn't exist.");
        }
        return user;
    }

    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmailAddress(email);
        if (user == null) {
            throw new UserNotFoundException("User with email: " + email + " doesn't exist.");
        }
        userRepository.delete(user);
    }

    public void deleteUserByName(String name) throws Exception {
        List<User> users = userRepository.findByName(name);
        
        if (users.size() > 1) {
            throw new Exception("Multiple users found with the name: " + name + ". No user deleted.");
        } else if (users.size() == 1) {
            userRepository.delete(users.get(0));
        } else {
            throw new Exception("No user found with the name: " + name + ".");
        }
    }
}
