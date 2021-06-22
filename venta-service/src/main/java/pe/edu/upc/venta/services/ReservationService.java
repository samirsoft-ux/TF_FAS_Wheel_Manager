package pe.edu.upc.venta.services;

import pe.edu.upc.venta.entities.Reservation;

import java.util.Optional;

public interface ReservationService extends CrudService<Reservation, Long>{
    Optional<Reservation> findByPrice(Double price) throws Exception;
}
