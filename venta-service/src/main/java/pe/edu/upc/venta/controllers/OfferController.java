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
import pe.edu.upc.venta.entities.Offer;
import pe.edu.upc.venta.services.OfferService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Offer>> fetchAll(){
        try {
            List<Offer> offers = offerService.findAll();
            return new ResponseEntity<List<Offer>>(offers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Para id
    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> fetchById(@PathVariable("id") Long id){
        try {
            Optional<Offer> optionalOffer = offerService.findById(id);
            if (optionalOffer.isPresent()){
                return new ResponseEntity<Offer>(optionalOffer.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Para offerName
    @GetMapping(path = "/offerName/{offerName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> fetchByOfferName(@PathVariable("offerName") String offerName){
        try {
            Optional<Offer> optionalOffer = offerService.findByOfferName(offerName);
            if (optionalOffer.isPresent()){
                return new ResponseEntity<Offer>(optionalOffer.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Para offerPrice
    @GetMapping(path = "/offerPrice/{offerPrice}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> fetchByOfferPrice(@PathVariable("offerPrice") Double offerPrice){
        try {
            Optional<Offer> optionalOffer = offerService.findByOfferPrice(offerPrice);
            if (optionalOffer.isPresent()){
                return new ResponseEntity<Offer>(optionalOffer.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
