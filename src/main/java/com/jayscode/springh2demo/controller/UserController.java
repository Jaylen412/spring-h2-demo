package com.jayscode.springh2demo.controller;

import com.jayscode.springh2demo.model.User;
import com.jayscode.springh2demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/addUser")
    public String addUser(@RequestBody User user) {
        userService.createUser(user);
        return user.getUserName() + " has been saved";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/saveUsers")
    public String addUsers(@RequestBody List<User> users) {
        userService.createUsers(users);
        return "Successfully saved users";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteUser/{userId}")
    public String deleteUser(@PathVariable UUID userId) {
        userService.deleteUserById(userId);
        return "User with id: " + userId + "has been deleted";
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/updateUser")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user.getUserName() + " Has been updated";
    }

}
