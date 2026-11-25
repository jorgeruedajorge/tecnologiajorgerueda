package com.rueda.tecnologia.controller;

import com.rueda.tecnologia.model.Cancion;
import com.rueda.tecnologia.service.CancionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    private final CancionService service;

    public CancionController(CancionService service) {
        this.service = service; }

    //listar todos
    @GetMapping
    public List<Cancion> listar() {
        return service.listar(); }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Cancion> buscar(@PathVariable Long id) {
        return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //crear uno nuevo
    @PostMapping
    public ResponseEntity<Cancion> crear(@RequestBody Cancion cancion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(cancion));
    }

    //actualizar uno por id
    @PutMapping("/{id}")
    public ResponseEntity<Cancion> actualizar(@PathVariable Long id, @RequestBody Cancion cancion) {
        return service.actualizar(id, cancion).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //borrar uno por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    //metodo especial
    @GetMapping("/conteo")
    public long contarGenero(@RequestParam String genero) {
        return service.contarGenero(genero); }
}
