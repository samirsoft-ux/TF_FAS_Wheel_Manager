package pe.edu.upc.user.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 40, nullable = false)
    private String userName;

    @Column(name = "password", length = 40, nullable = false)
    private String password;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "last_name", length = 40, nullable = false)
    private String lastName;

    @Column(name = "image_url",length = 40, nullable = false)
    @Lob //del projecto monolitico
    private String imageUrl;

    @Column(name = "dni",length = 8, nullable = false)
    private Long dni;

    @Column(name = "gender",length = 40, nullable = false)
    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birth_day",nullable = false, updatable = false)
    @CreatedDate
    private Date birthDay;

    //Buenas Practicas
    //Createdat y Status
    @Column(name = "created_at")//Forma correcta para el nombre de una tabla
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;  //tener cuidado con los nombres para un atributo de una clase

    @Column(length = 1, nullable = false)
    private String status;
    //Relaciones(No tiene Foreign Keys)
}
