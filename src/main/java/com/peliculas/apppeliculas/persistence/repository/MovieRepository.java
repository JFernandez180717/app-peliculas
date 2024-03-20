package com.peliculas.apppeliculas.persistence.repository;

import com.peliculas.apppeliculas.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
  List<MovieEntity> findByYear(String year);
}
