package com.promineotech.FETB.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.FETB.model.User;
import com.promineotech.FETB.service.UserService;

@RestController
@RequestMapping("/fet_db/users")
public class UserController {
  
  private UserService userService;
  
  public UserController(UserService userService) {
    super();
    this.userService = userService;
  }
  
  @PostMapping()
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
  }
  
  @GetMapping
  public List<User> getAllUsers(){
    return userService.getAllUsers();
  }
  
  @GetMapping("{user_pk}")
  public ResponseEntity<User> getUserByID(@PathVariable("user_pk") int userID){
    return new ResponseEntity<User>(userService.getUserByID(userID), HttpStatus.OK);
  }
  
  @PutMapping("{user_pk}")
  public ResponseEntity<User> updateUser(
      @PathVariable("user_pk") int userID, @RequestBody User user){
    return new ResponseEntity<User>(userService.updateUser(user, userID), HttpStatus.OK);
  }
  
  @DeleteMapping("{user_pk}")
  public ResponseEntity<String> deleteUser(@PathVariable("user_pk") int userID){
    userService.deleteUser(userID);
    return new ResponseEntity<String>("User Deleted!", HttpStatus.OK);
  }
}
