package pe.edu.upc.user.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Reservation {
    private Long id;
    private Date startDate;
    private Date endDate;
    private Double price;
}
