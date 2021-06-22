package pe.edu.upc.user.services;

import pe.edu.upc.user.entities.CreditCard;

import java.util.Optional;

public interface CreditCardService extends CrudService<CreditCard, Long>{
    Optional<CreditCard> findByCardNumber(String cardNumber) throws Exception;
    Optional<CreditCard> findByCardCvv(String cardCvv) throws Exception;
}
