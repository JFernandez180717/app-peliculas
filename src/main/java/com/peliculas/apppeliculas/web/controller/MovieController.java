package com.peliculas.apppeliculas.web.controller;

import com.peliculas.apppeliculas.persistence.entity.MovieEntity;
import com.peliculas.apppeliculas.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
  private final MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<MovieEntity>> findAll() {
    try {
      return ResponseEntity.ok(this.movieService.findAll());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/id/{movieId}")
  public ResponseEntity<MovieEntity> findById(@PathVariable("movieId") int movieId) {
    try {
      return this.movieService.findById(movieId).map(movie -> new ResponseEntity<>(movie, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/year/{year}")
  public ResponseEntity<List<MovieEntity>> findByYear(@PathVariable("year") String year) {
    try {
      return ResponseEntity.ok(this.movieService.findByYear(year));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }
}
