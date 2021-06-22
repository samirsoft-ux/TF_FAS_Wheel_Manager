package pe.edu.upc.user.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.user.entities.Subscription;
import pe.edu.upc.user.repositories.SubscriptionRepository;
import pe.edu.upc.user.services.SubscriptionService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Transactional
    @Override
    public Subscription save(Subscription entity) throws Exception {
        return subscriptionRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Subscription> findAll() throws Exception {
        return subscriptionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Subscription> findById(Long aLong) throws Exception {
        return subscriptionRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Subscription update(Subscription entity) throws Exception {
        return subscriptionRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        subscriptionRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public Optional<Subscription> findByPrice(Double price) throws Exception {
        return subscriptionRepository.findByPrice(price);
    }
}
