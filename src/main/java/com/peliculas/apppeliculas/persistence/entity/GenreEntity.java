package com.peliculas.apppeliculas.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
public class GenreEntity {
  @Id
  private String genre;

  @Column(nullable = false, length = 45)
  private String username;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "genre", referencedColumnName = "genre")
  private MovieEntity movie;

  @ManyToOne
  @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
  private UserEntity user;
}
