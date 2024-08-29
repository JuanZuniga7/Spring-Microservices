package com.example.users.services;

import com.example.users.dto.UserCredentials;
import com.example.users.model.User;
import com.example.users.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User loginUser(UserCredentials user) {
        User response = userRepository.findByEmail(user.getEmail());
        if (response == null) {
            throw new RuntimeException("User not found");
        }
        if (!response.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return response;
    }

}
