package pe.edu.upc.venta.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAddress {
    private Long id;
    private Boolean selected;
    private User user;
    private Address address;
}
