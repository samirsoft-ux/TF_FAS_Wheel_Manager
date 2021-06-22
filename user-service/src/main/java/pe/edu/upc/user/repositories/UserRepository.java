package pe.edu.upc.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.user.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName); //Nickname
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByDni(Long dni);
    Optional<User> findByGender(String gender);
}
