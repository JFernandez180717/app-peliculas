package com.peliculas.apppeliculas.service;

import com.peliculas.apppeliculas.persistence.entity.UserEntity;
import com.peliculas.apppeliculas.persistence.entity.UserRoleEntity;
import com.peliculas.apppeliculas.persistence.repository.UserRepository;
import com.peliculas.apppeliculas.persistence.repository.UserRoleRepository;
import com.peliculas.apppeliculas.service.dto.UserDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final UserRoleRepository userRoleRepository;

  @Autowired
  public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
    this.userRepository = userRepository;
    this.userRoleRepository = userRoleRepository;
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

  @Transactional
  public UserEntity create(UserDto user) throws Exception{
    UserEntity newUser = new UserEntity();
    newUser.setUsername(user.getUsername());
    newUser.setEmail(user.getEmail());
    newUser.setPassword(user.getPassword());
    newUser.setName(user.getName());
    newUser.setLastName(user.getLastName());
    newUser.setAge(user.getAge());
    newUser.setStatus(user.isStatus());
    newUser.setGender(user.getGender());
    UserEntity userCreated = this.userRepository.save(newUser);
    UserRoleEntity newUserRole = new UserRoleEntity();
    List<UserRoleEntity> roles = user.getRoles();
    for (UserRoleEntity role: roles) {
      this.userRoleRepository.save(role);
    }
    return userCreated;
  }

  public UserEntity update(UserDto user) {
    UserEntity userUpdate = this.userRepository.findById(user.getUsername()).orElse(null);
    if (userUpdate == null) {
      return null;
    }
    userUpdate.setEmail(user.getEmail());
    userUpdate.setPassword(user.getPassword());
    userUpdate.setName(user.getName());
    userUpdate.setLastName(user.getLastName());
    userUpdate.setAge(user.getAge());
    userUpdate.setGender(user.getGender());
    return this.userRepository.save(userUpdate);
  }

  @Transactional
  public void delete(String username) throws Exception{
    UserEntity user = this.userRepository.findById(username).orElse(null);
    List<UserRoleEntity> roles = user.getRoles();
    for (UserRoleEntity rol: roles) {
      this.userRoleRepository.delete(rol);
    }
    this.userRepository.deleteById(username);
  }

  public boolean exists(String username) {
    return this.userRepository.existsById(username);
  }
}
