package pe.edu.upc.producto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.producto.model.User;

@FeignClient(name = "user-service", fallback = UserHystrixFallbackFactory.class)
//@RequestMapping(value = "/users")
public interface UserClient {

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id);
}
