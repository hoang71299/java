package com.learnjava.identity_service.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnjava.identity_service.dto.resquest.UserCreationRequest;
import com.learnjava.identity_service.dto.resquest.UserUpdateRequest;
import com.learnjava.identity_service.entity.User;
import com.learnjava.identity_service.exception.ApiException;
import com.learnjava.identity_service.exception.ErrorCode;
import com.learnjava.identity_service.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User createUser(UserCreationRequest request) {
    User user = new User();
    if (userRepository.existsByUsername(request.getUsername()))
      throw new ApiException(ErrorCode.USER_EXISTED);

    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setDob(request.getDob());
    return userRepository.save(user);

  }

  public User updateUser(String userId, UserUpdateRequest request) {
    User user = getUser(userId);
    user.setPassword(request.getPassword());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setDob(request.getDob());
    return userRepository.save(user);
  }

  public void deleteUser(String userId) {
    userRepository.deleteById(userId);
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUser(String id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));
  }

}
