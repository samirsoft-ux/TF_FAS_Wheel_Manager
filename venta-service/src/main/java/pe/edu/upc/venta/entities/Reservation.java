package pe.edu.upc.venta.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

//ES IGUAL "private Date createdAt" A "@CreatedDate"?????
@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false, updatable = false)
    @CreatedDate
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false, updatable = false)
    @CreatedDate
    private Date endDate;

    @Column(name = "price", nullable = false)
    private Double price;

    //Buenas Practicas
    //Createdat y Status
    @Column(name = "created_at")//Forma correcta para el nombre de una tabla
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;  //tener cuidado con los nombres para un atributo de una clase

    @Column(length = 1, nullable = false)
    private String status;

    //****************************************************
    //Relaciones(Falta Foreign Keys)

    //Falta relacion "reservation" a "user" many to one
    //Falta relacion "reservation" a "vehicles" many to one

    //LAS RELACIONES SOLO SE PONEN EL MANYTOONE???????????????

}
