package com.peliculas.apppeliculas.persistence.repository;

import com.peliculas.apppeliculas.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface UserRepository extends CrudRepository<UserEntity, String> {
  Optional<UserEntity> findByEmail(String email);

  List<UserEntity> findByStatus(Boolean status);
}
