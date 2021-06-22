package pe.edu.upc.producto.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String name;
    private String lastName;
    private String imageUrl;
    private Long dni;
    private String gender;
    private Date birthDay;
}
