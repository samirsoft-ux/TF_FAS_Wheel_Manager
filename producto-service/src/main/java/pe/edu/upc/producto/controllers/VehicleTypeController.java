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
import pe.edu.upc.producto.entities.VehicleType;
import pe.edu.upc.producto.services.VehicleTypeService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/vehicle_types")
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleType>> fetchAll(){
        try {
            List<VehicleType> vehicleTypes = vehicleTypeService.findAll();
            return new ResponseEntity<List<VehicleType>>(vehicleTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleType> fetchById(@PathVariable("id") Long id){
        try {
            Optional<VehicleType> optionalVehicleType = vehicleTypeService.findById(id);
            if (optionalVehicleType.isPresent()){
                return new ResponseEntity<VehicleType>(optionalVehicleType.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //typeName
    @GetMapping(path = "/typeName/{typeName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleType> fetchByTypeName(@PathVariable("typeName") String typeName){
        try {
            Optional<VehicleType> optionalVehicleType = vehicleTypeService.findByTypeName(typeName);
            if (optionalVehicleType.isPresent()){
                return new ResponseEntity<VehicleType>(optionalVehicleType.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
