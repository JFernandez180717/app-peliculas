package com.peliculas.apppeliculas.service;

import com.peliculas.apppeliculas.persistence.entity.UserEntity;
import com.peliculas.apppeliculas.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserEntity> findAll() {
    return (List<UserEntity>) this.userRepository.findAll();
  }

  public UserEntity findById(String username) {
    return this.userRepository.findById(username).orElse(null);
  }

  public List<UserEntity> findActiveUsers(Boolean status) {
    return this.userRepository.findByStatus(status);
  }

  public UserEntity findByEmail(String email) {
    return this.userRepository.findByEmail(email).orElse(null);
  }

  public void createUser(UserEntity user) {
    this.userRepository.save(user);
  }
}
