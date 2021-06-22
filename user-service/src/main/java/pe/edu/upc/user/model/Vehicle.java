package pe.edu.upc.user.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {
    private Long id;
    private String vehicleName;
    private String imageUrl;
    private Integer calification;
    private String description;
    private Brand brand;
    private VehicleType vehicleType;
    private Situation situation;
}
