package com.example.crud.service;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User findUserByID(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public User updateUserByID(Long id, User updatedUser) {
        Optional<User> originalUser = userRepository.findById(id);
        if(originalUser.isPresent()){
            User user = originalUser.get();
            user.setEmail(updatedUser.getEmail());
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return new String("User deleted successfully");
        }
        return new String("User does not exist");
    }
}











