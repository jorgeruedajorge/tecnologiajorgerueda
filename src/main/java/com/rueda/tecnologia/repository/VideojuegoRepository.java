package com.rueda.tecnologia.repository;

import com.rueda.tecnologia.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    List<Videojuego> findByPrecioBetween(Double min, Double max);
}
