package com.peliculas.apppeliculas.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

  @OneToOne(mappedBy = "genre", fetch = FetchType.LAZY)
  @JsonIgnore
  private MovieEntity movie;

  @ManyToOne
  @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
  @JsonIgnore
  private UserEntity user;
}
