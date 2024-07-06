package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.PropertyDto;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//to take request from browser we are using this annotation

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
//try to take get request coming from the client/browser
    @Value("${pms.dummy}")
    private String dummy;

    @Autowired
    private PropertyService propertyService;


    @GetMapping("/hello")
    //Restful aPI is just mapping of a url to a java class function.
    public String sayHello() {
        return "Hello";
    }
    @PostMapping("/property")
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto){
        propertyService.saveProperty((propertyDto));
        ResponseEntity<PropertyDto> responseEntity= new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> getAllProperties(){
        System.out.println(dummy);
        List<PropertyDto> propertyList=propertyService.getAllProperties();
        ResponseEntity<List<PropertyDto>> responseEntity= new ResponseEntity<>(propertyList, HttpStatus.CREATED);
        return responseEntity;
    }
    @PutMapping("/properties/{propertyID}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyID){

        propertyDto=propertyService.updateProperty(propertyDto, propertyID);
        ResponseEntity<PropertyDto> responseEntity= new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return responseEntity;

    }
    @PatchMapping("/properties/update-description/{propertyID}")
    public ResponseEntity<PropertyDto> updatePropertyDescription(@RequestBody PropertyDto propertyDto ,@PathVariable Long propertyID){
        propertyDto=propertyService.updatePropertyDescription(propertyDto, propertyID);
        ResponseEntity<PropertyDto> responseEntity= new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;


    }
    @PatchMapping("/properties/update-price/{propertyID}")
    public ResponseEntity<PropertyDto> updatePropertyPrice(@RequestBody PropertyDto propertyDto , @PathVariable Long propertyID){
        propertyDto=propertyService.updatePropertyPrice(propertyDto, propertyID);
        ResponseEntity<PropertyDto> responseEntity= new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;

    }
    @DeleteMapping("/properties/{propertyID}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyID)
    {
        propertyService.deleteProperty(propertyID);
        ResponseEntity<Void> responseEntity= new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;

    }
}
