package pe.edu.upc.producto.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.producto.entities.VehicleType;
import pe.edu.upc.producto.repositories.VehicleTypeRepository;
import pe.edu.upc.producto.services.VehicleTypeService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Transactional
    @Override
    public VehicleType save(VehicleType entity) throws Exception {
        return vehicleTypeRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<VehicleType> findAll() throws Exception {
        return vehicleTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<VehicleType> findById(Long aLong) throws Exception {
        return vehicleTypeRepository.findById(aLong);
    }

    @Transactional
    @Override
    public VehicleType update(VehicleType entity) throws Exception {
        return vehicleTypeRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        vehicleTypeRepository.deleteById(aLong);
    }

    @Override
    public Optional<VehicleType> findByTypeName(String typeName) throws Exception {
        return vehicleTypeRepository.findByTypeName(typeName);
    }
}
