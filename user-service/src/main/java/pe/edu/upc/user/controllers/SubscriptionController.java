package pe.edu.upc.user.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.user.entities.Subscription;
import pe.edu.upc.user.services.SubscriptionService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Subscription>> fetchAll(){
        try {
            List<Subscription> subscriptions = subscriptionService.findAll();
            return new ResponseEntity<List<Subscription>>(subscriptions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subscription> fetchById(@PathVariable("id") Long id){
        try {
            Optional<Subscription> optionalSubscription = subscriptionService.findById(id);
            if (optionalSubscription.isPresent()){
                return new ResponseEntity<Subscription>(optionalSubscription.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //price
    @GetMapping(path = "/price/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subscription> fetchByPrice(@PathVariable("price") Double price){
        try {
            Optional<Subscription> optionalSubscription = subscriptionService.findByPrice(price);
            if (optionalSubscription.isPresent()){
                return new ResponseEntity<Subscription>(optionalSubscription.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
