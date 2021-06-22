package pe.edu.upc.user.services;

import pe.edu.upc.user.entities.Subscription;

import java.util.Optional;

public interface SubscriptionService extends CrudService<Subscription, Long>{
    Optional<Subscription> findByPrice(Double price) throws Exception;
}
