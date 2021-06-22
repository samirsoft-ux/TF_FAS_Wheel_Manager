package pe.edu.upc.venta.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Brand {
    private Long id;
    private String brandName;
}
