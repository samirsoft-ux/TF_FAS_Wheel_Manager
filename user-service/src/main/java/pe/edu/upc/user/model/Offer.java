package pe.edu.upc.user.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Offer {
    private Long id;
    private String offerName;
    private String description;
    private String imageUrl;
    private Date startDate;
    private Date endDate;
    private Double offerPrice;
}
