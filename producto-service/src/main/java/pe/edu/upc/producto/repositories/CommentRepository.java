package pe.edu.upc.producto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.producto.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
