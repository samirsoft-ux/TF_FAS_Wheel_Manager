package pe.edu.upc.venta.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.venta.entities.Offer;
import pe.edu.upc.venta.repositories.OfferRepository;
import pe.edu.upc.venta.services.OfferService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferRepository offerRepository;

    @Transactional
    @Override
    public Offer save(Offer entity) throws Exception {
        return offerRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Offer> findAll() throws Exception {
        return offerRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Offer> findById(Long aLong) throws Exception {
        return offerRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Offer update(Offer entity) throws Exception {
        return offerRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        offerRepository.deleteById(aLong);
    }
    //Método para que se pueda buscar una oferta por nombre
    @Transactional
    @Override
    public Optional<Offer> findByOfferName(String offerName) throws Exception {
        return offerRepository.findByOfferName(offerName);
    }

    @Transactional
    @Override
    public Optional<Offer> findByOfferPrice(Double offerPrice) throws Exception {
        return offerRepository.findByOfferPrice(offerPrice);
    }


}
