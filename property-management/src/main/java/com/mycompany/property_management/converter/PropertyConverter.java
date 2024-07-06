package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.PropertyDto;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity ConvertDTOtoEntity(PropertyDto propertyDto){
        PropertyEntity pe=new PropertyEntity();
        pe.setTitle(propertyDto.getTitle());
        pe.setAddress(propertyDto.getAddress());
        pe.setDescription(propertyDto.getDescription());
        pe.setOwnerName(propertyDto.getOwnerName());
        pe.setPrice(propertyDto.getPrice());
        pe.setOwnerEmail(propertyDto.getOwnerEmail());

        return pe;
    }
    public PropertyDto ConvertEntitytoDto(PropertyEntity propertyentity){

        PropertyDto propertyDTO =new PropertyDto();
        propertyDTO.setTitle(propertyentity.getTitle());
        propertyDTO.setAddress(propertyentity.getAddress());
        propertyDTO.setDescription(propertyentity.getDescription());
        propertyDTO.setOwnerName(propertyentity.getOwnerName());
        propertyDTO.setPrice(propertyentity.getPrice());
        propertyDTO.setOwnerEmail(propertyentity.getOwnerEmail());
        return propertyDTO;

    }
}
