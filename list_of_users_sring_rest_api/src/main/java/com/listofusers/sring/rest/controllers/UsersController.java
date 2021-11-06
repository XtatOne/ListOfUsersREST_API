package com.listofusers.sring.rest.controllers;

import com.listofusers.sring.rest.entity.Users;
import com.listofusers.sring.rest.exeptions.NoUserException;
import com.listofusers.sring.rest.service.UsersServeice.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/list")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<Users> getAllUsers() {

        List<Users> allUsers = usersService.getAllUsers();
        return allUsers;

    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable("id") int id) {

        Users user = getUserWithServer(id);
        return user;

    }

    @PostMapping("/users")
    public Users addUser(@RequestBody Users user) {

        usersService.saveUser(user);
        return user;

    }

    @PutMapping("/users")
    public Users editUser(@RequestBody Users user) {

        usersService.saveUser(user);
        return user;

    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {

        Users user = getUserWithServer(id);

        if (user != null) {
            usersService.deleteUser(id);
        }

        return "Пользователь с id " + id + " удален из БД.";

    }

    private Users getUserWithServer(int id) {

        Users user = null;

        Optional<Users> optionalUser = usersService.getUser(id);

        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new NoUserException("Пользователь с id " + id + " отсутствует в БД!");
        }

        return user;

    }

}


