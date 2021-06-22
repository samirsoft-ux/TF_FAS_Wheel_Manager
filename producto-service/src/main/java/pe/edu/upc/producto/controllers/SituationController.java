package pe.edu.upc.producto.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.producto.entities.Situation;
import pe.edu.upc.producto.services.SituationService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/situations")
public class SituationController {
    @Autowired
    private SituationService situationService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Situation>> fetchAll(){
        try {
            List<Situation> situations = situationService.findAll();
            return new ResponseEntity<List<Situation>>(situations, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Situation> fetchById(@PathVariable Long id){
        try {
            Optional<Situation> optionalSituation = situationService.findById(id);
            if (optionalSituation.isPresent()){
                return new ResponseEntity<Situation>(optionalSituation.get(), HttpStatus.OK);
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
    public ResponseEntity<Situation> fetchByName(@PathVariable String name){
        try {
            Optional<Situation> optionalSituation = situationService.findByName(name);
            if (optionalSituation.isPresent()){
                return new ResponseEntity<Situation>(optionalSituation.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
