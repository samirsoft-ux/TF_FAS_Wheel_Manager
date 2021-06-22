package pe.edu.upc.producto.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.producto.entities.Situation;
import pe.edu.upc.producto.repositories.SituationRepository;
import pe.edu.upc.producto.services.SituationService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SituationServiceImpl implements SituationService {
    @Autowired
    private SituationRepository situationRepository;

    @Transactional
    @Override
    public Situation save(Situation entity) throws Exception {
        return situationRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Situation> findAll() throws Exception {
        return situationRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Situation> findById(Long aLong) throws Exception {
        return situationRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Situation update(Situation entity) throws Exception {
        return situationRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        situationRepository.deleteById(aLong);
    }

    @Override
    public Optional<Situation> findByName(String name) throws Exception {
        return situationRepository.findByName(name);
    }
}
