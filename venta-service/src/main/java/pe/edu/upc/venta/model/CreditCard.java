package pe.edu.upc.venta.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreditCard {
    private Long id;
    private String cardNumber;
    private Date expirationDate;
    private String cardCvv;
    private User user;
}
