package com.rueda.tecnologia.controller;

import com.rueda.tecnologia.model.Videojuego;
import com.rueda.tecnologia.service.VideojuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    private final VideojuegoService service;

    public VideojuegoController(VideojuegoService service) {
        this.service = service; }

    //listar todos
    @GetMapping
    public List<Videojuego> listar() {
        return service.listar(); }

    //crear uno
    @PostMapping
    public ResponseEntity<Videojuego> crear(@RequestBody Videojuego videojuego) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(videojuego));
    }

    //metodo especial
    @GetMapping("/precio")
    public ResponseEntity<?> porRango(@RequestParam Double min, @RequestParam Double max) {
        if (min > max)
            return ResponseEntity.badRequest().body("'min' debe ser menor o igual que 'max'.");
        return ResponseEntity.ok(service.porRango(min, max));
    }
}
