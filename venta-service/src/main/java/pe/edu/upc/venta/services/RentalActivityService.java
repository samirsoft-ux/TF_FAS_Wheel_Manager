package pe.edu.upc.venta.services;

import pe.edu.upc.venta.entities.RentalActivity;

import java.util.Optional;

public interface RentalActivityService extends CrudService<RentalActivity, Long>{
    Optional<RentalActivity> findByPrice(Double price) throws Exception;
}
