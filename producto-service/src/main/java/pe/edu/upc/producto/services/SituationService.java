package pe.edu.upc.producto.services;

import pe.edu.upc.producto.entities.Situation;

import java.util.Optional;

public interface SituationService extends CrudService<Situation, Long>{
    Optional<Situation> findByName(String name) throws Exception;
}
