package pe.edu.upc.user.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.user.entities.User;
import pe.edu.upc.user.repositories.UserRepository;
import pe.edu.upc.user.services.UserService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User save(User entity) throws Exception {
        return userRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() throws Exception {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long aLong) throws Exception {
        return userRepository.findById(aLong);
    }

    @Transactional
    @Override
    public User update(User entity) throws Exception {
        return userRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        userRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public Optional<User> findByUserName(String userName) throws Exception {
        return userRepository.findByUserName(userName);
    }

    @Transactional
    @Override
    public Optional<User> findByEmail(String email) throws Exception {
        return userRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public Optional<User> findByName(String name) throws Exception {
        return userRepository.findByName(name);
    }

    @Transactional
    @Override
    public Optional<User> findByLastName(String lastName) throws Exception {
        return userRepository.findByLastName(lastName);
    }

    @Transactional
    @Override
    public Optional<User> findByDni(Long dni) throws Exception {
        return userRepository.findByDni(dni);
    }

    @Transactional
    @Override
    public Optional<User> findByGender(String gender) throws Exception {
        return userRepository.findByGender(gender);
    }
}
