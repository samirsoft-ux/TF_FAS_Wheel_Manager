package pe.edu.upc.venta.client;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.venta.model.Vehicle;

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
