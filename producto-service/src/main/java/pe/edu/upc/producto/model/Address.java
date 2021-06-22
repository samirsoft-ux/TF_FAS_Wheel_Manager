package pe.edu.upc.producto.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private Long id;
    private Double latitude;
    private Double longitude;
    private String description;
}
