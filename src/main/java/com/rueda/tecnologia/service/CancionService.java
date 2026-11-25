package com.rueda.tecnologia.service;

import com.rueda.tecnologia.model.Cancion;
import com.rueda.tecnologia.repository.CancionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CancionService {

    private final CancionRepository repository;

    public CancionService(CancionRepository repository) {
        this.repository = repository; }

    //traer todos
    public List<Cancion> listar() {
        return repository.findAll(); }

    //buscar
    public Optional<Cancion> buscar(Long id) {
        return repository.findById(id); }

    //crear
    public Cancion crear(Cancion cancion) { cancion.setId(null);
        return repository.save(cancion); }

    //actualizar
    public Optional<Cancion> actualizar(Long id, Cancion cambios) {
        return repository.findById(id).map(actual -> {
            actual.setTitulo(cambios.getTitulo()); actual.setArtista(cambios.getArtista());
            actual.setAlbum(cambios.getAlbum()); actual.setGenero(cambios.getGenero());
            actual.setDuracionSegundos(cambios.getDuracionSegundos());
            return repository.save(actual);
        });
    }

    //eliminar
    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id); return true;
    }

    //metodo especial
    public long contarGenero(String genero) {
        return repository.countByGeneroIgnoreCase(genero); }
}
