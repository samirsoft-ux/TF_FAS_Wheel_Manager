package pe.edu.upc.producto.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Subscription {
    private Long id;
    private String description;
    private Date startDate;
    private Double price;
    private User user;
}
