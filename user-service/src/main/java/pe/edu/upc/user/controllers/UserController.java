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
import pe.edu.upc.user.entities.User;
import pe.edu.upc.user.services.UserService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> fetchAll(){
        try {
            List<User> users = userService.findAll();
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> fetchById(@PathVariable("id") Long id){
        try {
            Optional<User> optionalUser = userService.findById(id);
            if (optionalUser.isPresent()){
                return new ResponseEntity<User>(optionalUser.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //userName
    @GetMapping(path = "/userName/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> fetchByUserName(@PathVariable("userName") String userName){
        try {
            Optional<User> optionalUser = userService.findByUserName(userName);
            if (optionalUser.isPresent()){
                return new ResponseEntity<User>(optionalUser.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //email
    @GetMapping(path = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> fetchByEmail(@PathVariable("email") String email){
        try {
            Optional<User> optionalUser = userService.findByEmail(email);
            if (optionalUser.isPresent()){
                return new ResponseEntity<User>(optionalUser.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //name
    @GetMapping(path = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> fetchByName(@PathVariable("name") String name){
        try {
            Optional<User> optionalUser = userService.findByName(name);
            if (optionalUser.isPresent()){
                return new ResponseEntity<User>(optionalUser.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //lastName
    @GetMapping(path = "/lastName/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> fetchByLastName(@PathVariable("lastName") String lastName){
        try {
            Optional<User> optionalUser = userService.findByLastName(lastName);
            if (optionalUser.isPresent()){
                return new ResponseEntity<User>(optionalUser.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //dni
    @GetMapping(path = "/dni/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> fetchByDni(@PathVariable("dni") Long dni){
        try {
            Optional<User> optionalUser = userService.findByDni(dni);
            if (optionalUser.isPresent()){
                return new ResponseEntity<User>(optionalUser.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //gender
    @GetMapping(path = "/gender/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> fetchByGender(@PathVariable("gender") String gender){
        try {
            Optional<User> optionalUser = userService.findByGender(gender);
            if (optionalUser.isPresent()){
                return new ResponseEntity<User>(optionalUser.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
