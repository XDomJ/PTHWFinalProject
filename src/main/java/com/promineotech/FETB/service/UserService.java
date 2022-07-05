package com.promineotech.FETB.service;

import java.util.List;
import com.promineotech.FETB.model.User;

public interface UserService {  
  User saveUser(User user);
  List<User> getAllUsers();
  User getUserByID(int id);
  User updateUser(User user, int id);
  void deleteUser(int id);
}
