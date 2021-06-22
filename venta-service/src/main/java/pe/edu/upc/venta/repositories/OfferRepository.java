package pe.edu.upc.venta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.venta.entities.Offer;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    //Método para que se pueda buscar una oferta por offerName
    Optional<Offer> findByOfferName(String offerName);

    //Método para que se pueda buscar una oferta por offerPrice
    Optional<Offer> findByOfferPrice(Double offerPrice);
}
