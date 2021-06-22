package pe.edu.upc.producto.services;

import pe.edu.upc.producto.entities.Vehicle;

import java.util.Optional;

public interface VehicleService extends CrudService<Vehicle, Long>{
    Optional<Vehicle> findByVehicleName(String name) throws Exception;
    Optional<Vehicle> findByCalification(Integer calification) throws Exception;
}
