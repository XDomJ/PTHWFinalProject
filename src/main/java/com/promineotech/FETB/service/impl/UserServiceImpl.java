package com.promineotech.FETB.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.FETB.exception.ResourceNotFoundException;
import com.promineotech.FETB.model.User;
import com.promineotech.FETB.repository.UserRepository;
import com.promineotech.FETB.service.UserService;

@Service
public class UserServiceImpl implements UserService{

  private UserRepository userRepository;
  
  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    super();
    this.userRepository = userRepository;
  }

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
  
  @Override
  public User getUserByID(int id) {
    return userRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("User", "Id", id));
  }
  
  @Override
  public User updateUser(User user, int id) {
    
    User foundUser = userRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("User", "Id", id));
    
    foundUser.setUser_id(user.getUser_id());
    
    
    
    return userRepository.save(foundUser);
  }

  @Override
  public void deleteUser(int id) {
    User foundUser = userRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("User", "Id", id));
    userRepository.deleteById(id);
    
  }
}
