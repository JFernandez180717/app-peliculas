package com.peliculas.apppeliculas.service.dto;

import com.peliculas.apppeliculas.persistence.entity.UserRoleEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
  private String username;
  private String email;
  private String password;
  private String name;
  private String lastName;
  private int age;
  private boolean status;
  private String gender;
  private List<UserRoleEntity> roles;
}
