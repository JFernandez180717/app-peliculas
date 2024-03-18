package com.peliculas.apppeliculas.web.controller;

import com.peliculas.apppeliculas.persistence.entity.UserEntity;
import com.peliculas.apppeliculas.service.UserService;
import com.peliculas.apppeliculas.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/{username}")
  public ResponseEntity<UserEntity> findById(@PathVariable("username") String username) {
    try {
      return ResponseEntity.ok(this.userService.findById(username));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<List<UserEntity>> findByActiveUsers(@PathVariable("status") Boolean status) {
    try {
      return ResponseEntity.ok(this.userService.findActiveUsers(status));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<UserEntity> findByEmail(@PathVariable("email") String email) {
    try {
      return ResponseEntity.ok(this.userService.findByEmail(email));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping("/create")
  public ResponseEntity<UserEntity> create(@RequestBody UserDto user) {
    try {
      return ResponseEntity.ok(this.userService.create(user));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping("/update")
  public ResponseEntity<UserEntity> update(@RequestBody UserDto user) {
    try {
      UserEntity userUpdate = this.userService.update(user);
      if (userUpdate != null) {
        return ResponseEntity.ok(userUpdate);
      }
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping("/delete/{username}")
  public ResponseEntity<Void> delete(@PathVariable("username") String username) {
    try {
      if (this.userService.exists(username)) {
        this.userService.delete(username);
        return ResponseEntity.ok().build();
      }
      return ResponseEntity.badRequest().build();
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }
}
