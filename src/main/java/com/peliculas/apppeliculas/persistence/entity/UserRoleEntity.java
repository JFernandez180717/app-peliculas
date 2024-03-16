package com.peliculas.apppeliculas.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peliculas.apppeliculas.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user_role")
@EntityListeners(AuditingEntityListener.class)
@IdClass(UserRoleId.class)
@Getter
@Setter
@NoArgsConstructor
public class UserRoleEntity extends AuditableEntity {
  @Id
  @Column(nullable = false, length = 45)
  private String username;

  @Id
  @Column(nullable = false, length = 45)
  private String role;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
  private UserEntity user;
}
