package com.tcm.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User userToCreate) {
        this.repository.save(userToCreate);
        return userToCreate;
    }

    public List<User> getUsers() throws Exception {
        List<User> users = new ArrayList<>();
        this.repository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(String id) throws Exception {
        return this.repository.findById(id).get();
    }

    public void removeAllUsers() {
        this.repository.deleteAll();
    }

    public void removeUser(String id) {
        this.repository.deleteById(id);
    }

    public void updateUser(@RequestBody User userToUpdate, @PathVariable String id) throws Exception {
        User user = getUser(id);
        user.setEmail(userToUpdate.getEmail());
        user.setGender(userToUpdate.getGender());
        user.setPassword(userToUpdate.getPassword());
        repository.save(user);
    }
}
