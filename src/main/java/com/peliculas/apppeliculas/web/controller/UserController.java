package com.peliculas.apppeliculas.web.controller;

import com.peliculas.apppeliculas.persistence.entity.UserEntity;
import com.peliculas.apppeliculas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<UserEntity>> findAll() {
    try {
      return ResponseEntity.ok(this.userService.findAll());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping("/{username}")
  public ResponseEntity<UserEntity> findById(@PathVariable("username") String username) {
    try {
      return ResponseEntity.ok(this.userService.findById(username));
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<List<UserEntity>> findByActiveUsers(@PathVariable("status") Boolean status) {
    try {
      return ResponseEntity.ok(this.userService.findActiveUsers(status));
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<UserEntity> findByEmail(@PathVariable("email") String email) {
    try {
      return ResponseEntity.ok(this.userService.findByEmail(email));
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
