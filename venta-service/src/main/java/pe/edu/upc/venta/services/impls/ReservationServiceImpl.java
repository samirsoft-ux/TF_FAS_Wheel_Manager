package pe.edu.upc.venta.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.venta.entities.Reservation;
import pe.edu.upc.venta.repositories.ReservationRepository;
import pe.edu.upc.venta.services.ReservationService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Transactional
    @Override
    public Reservation save(Reservation entity) throws Exception {
        return reservationRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Reservation> findAll() throws Exception {
        return reservationRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Reservation> findById(Long aLong) throws Exception {
        return reservationRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Reservation update(Reservation entity) throws Exception {
        return reservationRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        reservationRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public Optional<Reservation> findByPrice(Double price) throws Exception {
        return reservationRepository.findByPrice(price);
    }
}
