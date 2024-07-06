package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

    public PropertyDto saveProperty(PropertyDto propertyDto);
     List<PropertyDto> getAllProperties();
    PropertyDto updateProperty( PropertyDto propertyDto , Long propertyId);
    PropertyDto updatePropertyPrice(@RequestBody PropertyDto propertyDto , Long propertyId);
    PropertyDto updatePropertyDescription(@RequestBody PropertyDto propertyDto , Long propertyID);
    void deleteProperty(Long propertyID);

    //we want to return the updated property so return type is propertyDto at line 11
}
