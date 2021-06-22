package pe.edu.upc.producto.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RentalActivity {
    private Long id;
    private Double price;
    private Double comission;
    private Double insurancePrice;
    private Offer offer;
    private Reservation reservation;
}
