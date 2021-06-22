package pe.edu.upc.user.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.user.entities.UserAddress;
import pe.edu.upc.user.repositories.UserAddressRepository;
import pe.edu.upc.user.services.UserAddressService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressRepository userAddressRepository;

    @Transactional
    @Override
    public UserAddress save(UserAddress entity) throws Exception {
        return userAddressRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserAddress> findAll() throws Exception {
        return userAddressRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UserAddress> findById(Long aLong) throws Exception {
        return userAddressRepository.findById(aLong);
    }

    @Transactional
    @Override
    public UserAddress update(UserAddress entity) throws Exception {
        return userAddressRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        userAddressRepository.deleteById(aLong);
    }
}
