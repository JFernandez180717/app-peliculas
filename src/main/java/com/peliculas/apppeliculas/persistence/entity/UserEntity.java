package com.peliculas.apppeliculas.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peliculas.apppeliculas.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends AuditableEntity{
  @Id
  @Column(nullable = false, length = 45)
  private String username;

  @Column(nullable = false, length = 45)
  private String email;

  @Column(nullable = false, length = 200)
  private String password;

  @Column(nullable = false, length = 45)
  private String name;

  @Column(nullable = false, length = 45)
  private String lastName;

  @Column(nullable = false)
  private int age;

  @Column(nullable = false)
  private boolean status;

  @Column(nullable = false, length = 1)
  private String gender;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private List<UserRoleEntity> roles;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  @JsonIgnore
  private List<MovieEntity> movies;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  @JsonIgnore
  private List<GenreEntity> genres;


}
