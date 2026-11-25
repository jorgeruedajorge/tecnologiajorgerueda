package com.rueda.tecnologia.repository;

import com.rueda.tecnologia.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByCiudadIgnoreCase(String ciudad);
}
