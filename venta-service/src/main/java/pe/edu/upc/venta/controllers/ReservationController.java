package pe.edu.upc.venta.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.venta.entities.Reservation;
import pe.edu.upc.venta.services.ReservationService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reservation>> fetchAll(){
        try {
            List<Reservation> reservations = reservationService.findAll();
            return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //para id
    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> fetchById(@PathVariable("id") Long id){
        try {
            Optional<Reservation> optionalReservation = reservationService.findById(id);
            if (optionalReservation.isPresent()){
                return new ResponseEntity<Reservation>(optionalReservation.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //para price
    @GetMapping(path = "/price/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> fetchByPrice(@PathVariable("price") Double price){
        try {
            Optional<Reservation> optionalReservation = reservationService.findByPrice(price);
            if (optionalReservation.isPresent()){
                return new ResponseEntity<Reservation>(optionalReservation.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
