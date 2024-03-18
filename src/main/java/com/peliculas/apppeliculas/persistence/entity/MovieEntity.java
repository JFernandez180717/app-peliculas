package com.peliculas.apppeliculas.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
public class MovieEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 500)
  private String logoPath;

  @Column(nullable = false, length = 45)
  private String description;

  @Column(nullable = false, length = 4)
  private String year;

  private int qualification;

  /*@Column(nullable = false, length = 40)
  private String genre;*/

  @Column(nullable = false, length = 45)
  private String username;

  //@OneToOne(mappedBy = "movie", fetch = FetchType.LAZY)
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "genre", referencedColumnName = "genre", insertable = false, updatable = false)
  private GenreEntity genre;

  @ManyToOne
  @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
  private UserEntity user;

}
