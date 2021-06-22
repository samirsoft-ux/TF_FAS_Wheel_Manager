package pe.edu.upc.user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_addresses")
@Data
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "selected", nullable = false)
    private Boolean selected;

    //Buenas Practicas
    //Createdat y Status
    @Column(name = "created_at")//Forma correcta para el nombre de una tabla
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;  //tener cuidado con los nombres para un atributo de una clase

    @Column(length = 1, nullable = false)
    private String status;
    //Relaciones(Falta Foreign Keys)

    //relacion "user address" a "user" many to one
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    //relacion "user addres" a "address" many to one
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "address_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Address address;
}
