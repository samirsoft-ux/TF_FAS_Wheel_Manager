package pe.edu.upc.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.user.entities.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
}
