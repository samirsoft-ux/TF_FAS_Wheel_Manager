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
import pe.edu.upc.producto.entities.Brand;
import pe.edu.upc.producto.services.BrandService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    //esto acabo de crear 17/06/2021
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Brand>> fetchAll(){
        try {
            List<Brand> brands = brandService.findAll();
            return new ResponseEntity<List<Brand>>(brands, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> fetchById(@PathVariable("id") Long id){
        try {
            Optional<Brand> optionalBrand = brandService.findById(id);
            if (optionalBrand.isPresent()){
                return new ResponseEntity<Brand>(optionalBrand.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //brandName
    @GetMapping(path = "/brandName/{brandName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> fetchByBrandName(@PathVariable("brandName") String brandName){
        try {
            Optional<Brand> optionalBrand = brandService.findByBrandName(brandName);
            if (optionalBrand.isPresent()){
                return new ResponseEntity<Brand>(optionalBrand.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
