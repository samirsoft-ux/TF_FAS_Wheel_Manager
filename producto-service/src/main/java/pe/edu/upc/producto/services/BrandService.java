package pe.edu.upc.producto.services;

import pe.edu.upc.producto.entities.Brand;

import java.util.Optional;

public interface BrandService extends CrudService<Brand, Long>{
    Optional<Brand> findByBrandName(String brandName) throws Exception;
}
