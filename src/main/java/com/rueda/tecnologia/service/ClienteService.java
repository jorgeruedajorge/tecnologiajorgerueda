package com.rueda.tecnologia.service;

import com.rueda.tecnologia.model.Cliente;
import com.rueda.tecnologia.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {


    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository; }

    //traer todos
    public List<Cliente> listar() {
        return repository.findAll(); }

    //crear
    public Cliente crear(Cliente cliente) { cliente.setId(null);
        return repository.save(cliente); }

    //metodo especial
    public List<Cliente> porCiudad(String ciudad) {
        return repository.findByCiudadIgnoreCase(ciudad); }
}
