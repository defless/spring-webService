package com.cours.spring.controllers;

import com.cours.spring.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cours.spring.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Récupération de tous les utilisateurs")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Récupération d'un utilisateur")
    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public User get(@PathVariable(name = "username") String username) {
        return userService.getUserById(username);
    }

    @Operation(summary = "Modification ou création d'un utilisateur")
    @RequestMapping(method = RequestMethod.PUT)
    public User createOrUPdate(@RequestBody User user) {
        return userService.createOrUpdate(user);
    }

    @Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "username") String username) {
        userService.deleteUser(username);
    }
}