package pe.edu.upc.producto.services;

import pe.edu.upc.producto.entities.VehicleType;

import java.util.Optional;

public interface VehicleTypeService extends CrudService<VehicleType, Long>{
    Optional<VehicleType> findByTypeName(String typeName) throws Exception;
}
