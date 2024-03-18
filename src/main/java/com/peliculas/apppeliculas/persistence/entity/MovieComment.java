package com.peliculas.apppeliculas.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie_comment")
@Getter
@Setter
@NoArgsConstructor
public class MovieComment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "movie_id", nullable = false)
  private int movieId;

  @Column(nullable = false, length = 500)
  private String comment;

  @Column(nullable = false, length = 45)
  private String username;

  @ManyToOne
  @JoinColumn(name = "movie_id", referencedColumnName = "id", insertable = false, updatable = false)
  private MovieEntity movie;

  @ManyToOne
  @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
  private UserEntity user;

}
