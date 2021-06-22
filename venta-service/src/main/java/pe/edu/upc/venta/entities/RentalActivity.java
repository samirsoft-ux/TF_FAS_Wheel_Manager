package pe.edu.upc.venta.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rental_activities")
@Data
public class RentalActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "comission", nullable = false)
    private Double comission;

    @Column(name = "insurance_price", nullable = false)
    private Double insurancePrice;

    //Buenas Practicas
    //Createdat y Status
    @Column(name = "created_at")//Forma correcta para el nombre de una tabla
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;  //tener cuidado con los nombres para un atributo de una clase

    @Column(length = 1, nullable = false)
    private String status;
    //Relaciones(Falta Foreign Keys)

    //Poner las relaciones
    //relacion "rental activity" a "offer" many to one
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "offer_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Offer offer;

    //relacion "rental activity" a "reservation" many to one
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "reservation_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Reservation reservation;

    //LAS RELACIONES SOLO SE PONEN EL MANYTOONE???????????????
}
