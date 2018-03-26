package com.only_gary.controller;

import com.only_gary.DaoImpl.UserDaoImpl;
import com.only_gary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody User addNewUser(@RequestParam String name
            , @RequestParam String email) {

        return userDaoImpl.addNewUser(name, email);

    }

    //Return user with userId
    @GetMapping(path="/getById")
    public @ResponseBody User getUserById(@RequestParam int id) {

        return userDaoImpl.getUserById(id);
    }

    //Return user with userName
    @GetMapping(path="/getByUsername")
    public @ResponseBody User getUserByUsername(@RequestParam String username) {

        return userDaoImpl.getUserByUsername(username);
    }

    //Return all users
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userDaoImpl.getAllUsers();
    }

}