package pe.edu.upc.venta.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.venta.entities.RentalActivity;
import pe.edu.upc.venta.repositories.RentalActivityRepository;
import pe.edu.upc.venta.services.RentalActivityService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RentalActivityServiceImpl implements RentalActivityService {
    @Autowired
    private RentalActivityRepository rentalActivityRepository;

    @Transactional
    @Override
    public RentalActivity save(RentalActivity entity) throws Exception {
        return rentalActivityRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RentalActivity> findAll() throws Exception {
        return rentalActivityRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<RentalActivity> findById(Long aLong) throws Exception {
        return rentalActivityRepository.findById(aLong);
    }

    @Transactional
    @Override
    public RentalActivity update(RentalActivity entity) throws Exception {
        return rentalActivityRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        rentalActivityRepository.deleteById(aLong);
    }

    //Método que yo he implementado
    @Transactional
    @Override
    public Optional<RentalActivity> findByPrice(Double price) throws Exception {
        return rentalActivityRepository.findByPrice(price);
    }
}
