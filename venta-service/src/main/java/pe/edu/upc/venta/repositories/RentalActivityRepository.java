package pe.edu.upc.venta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.venta.entities.RentalActivity;

import java.util.Optional;

@Repository
public interface RentalActivityRepository extends JpaRepository<RentalActivity, Long> {
    //Método para que se pueda buscar un rentalactivity por price
    Optional<RentalActivity> findByPrice(Double price);
}
