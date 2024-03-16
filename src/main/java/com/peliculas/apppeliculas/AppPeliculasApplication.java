package com.peliculas.apppeliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppPeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPeliculasApplication.class, args);
	}

}
