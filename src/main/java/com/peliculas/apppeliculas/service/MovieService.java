package com.peliculas.apppeliculas.service;

import com.peliculas.apppeliculas.persistence.entity.MovieEntity;
import com.peliculas.apppeliculas.persistence.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
  private final MovieRepository movieRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<MovieEntity> findAll(){
    return (List<MovieEntity>) this.movieRepository.findAll();
  }

  public Optional<MovieEntity> findById(int movieId) {
    return this.movieRepository.findById(movieId);
  }
}
