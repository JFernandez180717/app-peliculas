package com.peliculas.apppeliculas.persistence.repository;

import com.peliculas.apppeliculas.persistence.entity.UserRoleEntity;
import com.peliculas.apppeliculas.persistence.entity.UserRoleId;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity, UserRoleId> {
}
