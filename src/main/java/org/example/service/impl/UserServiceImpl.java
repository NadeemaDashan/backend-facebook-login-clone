package org.example.service.impl;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean addUsers(User user) {
        if (!user.getUsername().isEmpty() && !user.getPassword().isEmpty()) {
            if (!userRepository.existsByUsername(user.getUsername())){
                String encode = passwordEncoder.encode(user.getPassword());
                User save = userRepository.save(new User(user.getUsername(),encode));
                return true;
            }
        }else {
            return false;
        }
        return false;
    }

    @Override
    public boolean loginUser(User user) {
        User dbUser= userRepository.findByUsername(user.getUsername());
        if (dbUser!=null){
            return passwordEncoder.matches(user.getPassword(), dbUser.getPassword());
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
