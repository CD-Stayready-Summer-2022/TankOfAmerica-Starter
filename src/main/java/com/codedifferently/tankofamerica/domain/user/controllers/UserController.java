package com.codedifferently.tankofamerica.domain.user.controllers;

import com.codedifferently.tankofamerica.domain.user.models.User;
import com.codedifferently.tankofamerica.domain.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ShellMethod("Create a new User")
    public User createNewUser(@ShellOption({"-F", "--firstname"}) String firstName,
                              @ShellOption({"-L", "--lastname"})String lastName,
                              @ShellOption({"-E", "--email"})String email,
                              @ShellOption({"-P", "--password"})String password){
        User user = new User(firstName,lastName,email,password);
        user = userService.create(user);
        return user;

    }

    @ShellMethod("Get All Users")
    public String getAllUsers(){
        return userService.getAllUsers();
    }
}
