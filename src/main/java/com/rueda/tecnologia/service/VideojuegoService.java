package com.rueda.tecnologia.service;

import com.rueda.tecnologia.model.Videojuego;
import com.rueda.tecnologia.repository.VideojuegoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideojuegoService {


    private final VideojuegoRepository repository;

    public VideojuegoService(VideojuegoRepository repository) {
        this.repository = repository; }

    //listar todos
    public List<Videojuego> listar() {
        return repository.findAll(); }

    //crear
    public Videojuego crear(Videojuego videojuego) { videojuego.setId(null);
        return repository.save(videojuego); }

    //metodo especial
    public List<Videojuego> porRango(Double min, Double max) {
        return repository.findByPrecioBetween(min, max); }
}
