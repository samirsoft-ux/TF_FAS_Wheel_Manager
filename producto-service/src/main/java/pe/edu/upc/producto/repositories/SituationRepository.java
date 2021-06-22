package pe.edu.upc.producto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.producto.entities.Situation;

import java.util.Optional;

@Repository
public interface SituationRepository extends JpaRepository<Situation, Long> {
    Optional<Situation> findByName(String name);
}
