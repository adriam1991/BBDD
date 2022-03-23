package com.tcm.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private UserController controller;

    public UserRestController(UserController controller) {
        this.controller = controller;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User userToCreate) {
       return controller.createUser(userToCreate);
    }

    @GetMapping("/users")
    public List<User> getUser() throws Exception {
        return controller.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) throws Exception {
       return controller.getUser(id);
    }

    @DeleteMapping("/users")
    public void removeAllUsers() {
        controller.removeAllUsers();
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable String id) {
        controller.removeUser(id);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User userToUpdate, @PathVariable String id) throws Exception {
        controller.updateUser(userToUpdate,id);
    }

}
