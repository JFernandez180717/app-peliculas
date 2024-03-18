package com.peliculas.apppeliculas.persistence.repository;

import com.peliculas.apppeliculas.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
}
