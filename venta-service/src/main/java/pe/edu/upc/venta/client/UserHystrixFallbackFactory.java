package pe.edu.upc.venta.client;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.venta.model.User;

public class UserHystrixFallbackFactory implements UserClient{
    @Override
    public ResponseEntity<User> getUser(Long id) {
        User user = User.builder()
                .name("none")
                .lastName("none")
                .email("none")
                .imageUrl("none").build();
        return ResponseEntity.ok(user);
    }
}
