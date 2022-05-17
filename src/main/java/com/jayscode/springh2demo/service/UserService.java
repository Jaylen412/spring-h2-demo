package com.jayscode.springh2demo.service;

import com.jayscode.springh2demo.model.User;
import com.jayscode.springh2demo.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void createUsers(List<User> users) {
        userRepository.saveAll(users);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
       Optional<User> optionalUser = userRepository.findById(user.getId());
       if (optionalUser.isPresent()) {
           User currentUser = optionalUser.get();
           currentUser.setUserName(user.getUserName());
           userRepository.save(currentUser);
           return currentUser;
       }
       log.info("Null User");
        return null;
    }

    public String deleteUserById(UUID id) {
        userRepository.deleteById(id);
        return "User with id:" + id + "has been deleted";
    }

}
