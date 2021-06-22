package pe.edu.upc.user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit_cards")
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", length = 40, nullable = false)
    private String cardNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiration_date", nullable = false, updatable = false)
    @CreatedDate
    private Date expirationDate;

    @Column(name = "card_cvv", length = 40, nullable = false)
    private String cardCvv;

    //Buenas Practicas
    //Createdat y Status
    @Column(name = "created_at")//Forma correcta para el nombre de una tabla
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;  //tener cuidado con los nombres para un atributo de una clase

    @Column(length = 1, nullable = false)
    private String status;
    //Relaciones(Falta Foreign Keys)

    //relacion "credit card" a "user" many to one
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}
