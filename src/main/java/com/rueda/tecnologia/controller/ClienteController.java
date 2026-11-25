package com.rueda.tecnologia.controller;

import com.rueda.tecnologia.model.Cliente;
import com.rueda.tecnologia.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service; }

    //listar todos
    @GetMapping
    public List<Cliente> listar() {
        return service.listar(); }

    //crear uno
    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(cliente));
    }

    // metodo especial
    @GetMapping("/ciudad")
    public List<Cliente> porCiudad(@RequestParam("nombre") String ciudad) {
        return service.porCiudad(ciudad);
    }
}
