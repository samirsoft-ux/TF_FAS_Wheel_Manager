package pe.edu.upc.user.client;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.user.model.Vehicle;

public class ProductoHystrixFallbackFactory implements ProductoClient{
    @Override
    public ResponseEntity<Vehicle> getVehicle(Long id) {
        Vehicle vehicle = Vehicle.builder()
                .vehicleName("none")
                .description("none")
                .imageUrl("none").build();
        return ResponseEntity.ok(vehicle);
    }
}
