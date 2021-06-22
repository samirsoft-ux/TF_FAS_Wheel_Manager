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
import pe.edu.upc.venta.entities.RentalActivity;
import pe.edu.upc.venta.services.RentalActivityService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/rental_activities")
public class RentalActivityController {
    @Autowired
    private RentalActivityService rentalActivityService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RentalActivity>> fetchAll(){
        try {
            List<RentalActivity> rentalActivities = rentalActivityService.findAll();
            return new ResponseEntity<List<RentalActivity>>(rentalActivities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentalActivity> fetchById(@PathVariable("id") Long id){
        try {
            Optional<RentalActivity> optionalRentalActivity = rentalActivityService.findById(id);
            if (optionalRentalActivity.isPresent()){
                return new ResponseEntity<RentalActivity>(optionalRentalActivity.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Para price
    @GetMapping(path = "/price/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentalActivity> fetchByPrice(@PathVariable("price") Double price){
        try {
            Optional<RentalActivity> optionalRentalActivity = rentalActivityService.findByPrice(price);
            if (optionalRentalActivity.isPresent()){
                return new ResponseEntity<RentalActivity>(optionalRentalActivity.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
