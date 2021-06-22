package pe.edu.upc.venta.services;

import pe.edu.upc.venta.entities.Offer;

import java.util.Optional;

public interface OfferService extends CrudService<Offer, Long>{
    //Método para que se pueda buscar una oferta por offerName
    Optional<Offer> findByOfferName(String offerName) throws Exception;

    //Método para que se pueda buscar una oferta por offerPrice
    Optional<Offer> findByOfferPrice(Double offerPrice) throws Exception;
}
