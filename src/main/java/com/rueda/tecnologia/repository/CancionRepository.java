package com.rueda.tecnologia.repository;

import com.rueda.tecnologia.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
    long countByGeneroIgnoreCase(String genero);
}
