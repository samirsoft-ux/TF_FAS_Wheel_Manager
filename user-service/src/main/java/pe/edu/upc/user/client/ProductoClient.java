package pe.edu.upc.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.user.model.Vehicle;

@FeignClient(name = "producto-service", fallback = ProductoHystrixFallbackFactory.class)
//@RequestMapping(value = "/productos")
public interface ProductoClient {

    @GetMapping(value = "/productos/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") Long id);
}
