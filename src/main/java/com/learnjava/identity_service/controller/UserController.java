package com.learnjava.identity_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.identity_service.dto.resquest.UserCreationRequest;
import com.learnjava.identity_service.dto.resquest.UserUpdateRequest;
import com.learnjava.identity_service.entity.User;
import com.learnjava.identity_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping()
  User createUser(@RequestBody UserCreationRequest request) {
    return userService.createUser(request);
  }

  @GetMapping()
  List<User> getUser() {
    return userService.getUsers();
  }

  @GetMapping("/{userId}")
  User getUser(@PathVariable String userId) {
    return userService.getUser(userId);
  }

  @PutMapping("/{userId}")
  User update(@RequestBody UserUpdateRequest request, @PathVariable String userId) {
    return userService.updateUser(userId, request);
  }

  @DeleteMapping("/{userId}")
  String deleteUser(@PathVariable String userId) {
    userService.deleteUser(userId);
    return "User has been delete";
  }
}