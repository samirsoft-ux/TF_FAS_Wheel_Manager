package pe.edu.upc.producto.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.producto.entities.Brand;
import pe.edu.upc.producto.repositories.BrandRepository;
import pe.edu.upc.producto.services.BrandService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Transactional
    @Override
    public Brand save(Brand entity) throws Exception {
        return brandRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Brand> findAll() throws Exception {
        return brandRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Brand> findById(Long aLong) throws Exception {
        return brandRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Brand update(Brand entity) throws Exception {
        return brandRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        brandRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public Optional<Brand> findByBrandName(String brandName) throws Exception {
        return brandRepository.findByBrandName(brandName);
    }
}
