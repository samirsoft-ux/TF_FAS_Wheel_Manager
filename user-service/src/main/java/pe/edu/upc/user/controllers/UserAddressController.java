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
import pe.edu.upc.user.entities.UserAddress;
import pe.edu.upc.user.services.UserAddressService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user_addresses")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserAddress>> fetchAll(){
        try {
            List<UserAddress> userAddresses = userAddressService.findAll();
            return new ResponseEntity<List<UserAddress>>(userAddresses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAddress> fetchById(@PathVariable("id") Long id){
        try {
            Optional<UserAddress> optionalUserAddress = userAddressService.findById(id);
            if (optionalUserAddress.isPresent()){
                return new ResponseEntity<UserAddress>(optionalUserAddress.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
