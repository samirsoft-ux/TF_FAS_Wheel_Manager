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
import pe.edu.upc.user.entities.CreditCard;
import pe.edu.upc.user.services.CreditCardService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/credit_cards")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreditCard>> fetchAll(){
        try {
            List<CreditCard> creditCards = creditCardService.findAll();
            return new ResponseEntity<List<CreditCard>>(creditCards, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> fetchById(@PathVariable("id") Long id){
        try {
            Optional<CreditCard> optionalCreditCard = creditCardService.findById(id);
            if (optionalCreditCard.isPresent()){
                return new ResponseEntity<CreditCard>(optionalCreditCard.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //cardnumber
    @GetMapping(path = "/number/{cardNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> fetchByCardNumber(@PathVariable("cardNumber") String cardNumber){
        try {
            Optional<CreditCard> optionalCreditCard = creditCardService.findByCardNumber(cardNumber);
            if (optionalCreditCard.isPresent()){
                return new ResponseEntity<CreditCard>(optionalCreditCard.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //cardcvv
    @GetMapping(path = "/cvv/{cardCvv}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> fetchByCardCvv(@PathVariable("cardCvv") String cardCvv){
        try {
            Optional<CreditCard> optionalCreditCard = creditCardService.findByCardCvv(cardCvv);
            if (optionalCreditCard.isPresent()){
                return new ResponseEntity<CreditCard>(optionalCreditCard.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
