package pe.edu.upc.user.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.user.entities.Address;
import pe.edu.upc.user.repositories.AddressRepository;
import pe.edu.upc.user.services.AddressService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    @Override
    public Address save(Address entity) throws Exception {
        return addressRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Address> findAll() throws Exception {
        return addressRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Address> findById(Long aLong) throws Exception {
        return addressRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Address update(Address entity) throws Exception {
        return addressRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        addressRepository.deleteById(aLong);
    }
}
