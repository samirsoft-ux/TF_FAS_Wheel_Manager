package pe.edu.upc.producto.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.producto.entities.Vehicle;
import pe.edu.upc.producto.repositories.VehicleRepository;
import pe.edu.upc.producto.services.VehicleService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    @Override
    public Vehicle save(Vehicle entity) throws Exception {
        return vehicleRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Vehicle> findAll() throws Exception {
        return vehicleRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Vehicle> findById(Long aLong) throws Exception {
        return vehicleRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Vehicle update(Vehicle entity) throws Exception {
        return vehicleRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        vehicleRepository.deleteById(aLong);
    }

    @Override
    public Optional<Vehicle> findByVehicleName(String name) throws Exception {
        return vehicleRepository.findByVehicleName(name);
    }

    @Override
    public Optional<Vehicle> findByCalification(Integer calification) throws Exception {
        return vehicleRepository.findByCalification(calification);
    }
}
