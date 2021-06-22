package pe.edu.upc.user.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.user.entities.CreditCard;
import pe.edu.upc.user.repositories.CreditCardRepository;
import pe.edu.upc.user.services.CreditCardService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Transactional
    @Override
    public CreditCard save(CreditCard entity) throws Exception {
        return creditCardRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CreditCard> findAll() throws Exception {
        return creditCardRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CreditCard> findById(Long aLong) throws Exception {
        return creditCardRepository.findById(aLong);
    }

    @Transactional
    @Override
    public CreditCard update(CreditCard entity) throws Exception {
        return creditCardRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        creditCardRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public Optional<CreditCard> findByCardNumber(String cardNumber) throws Exception {
        return creditCardRepository.findByCardNumber(cardNumber);
    }

    @Transactional
    @Override
    public Optional<CreditCard> findByCardCvv(String cardCvv) throws Exception {
        return creditCardRepository.findByCardCvv(cardCvv);
    }
}
