package com.mycompany.property_management.service.impl;


import com.mycompany.property_management.Repository.PropertyRepository;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDto;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//there can be multiple inplementation class for one service (factory design pattern)
//singleton where one instance/object of a class is created
//prototype where multiple instance of a class is created and destroyed
@Service //to make this class object as singelton object will be created once
public class PropertyServiceImpl implements PropertyService {
//propertydto is used as prototype created again and again
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyconverter;
    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto) {
        //adapter design pattern where we are converting dto to entity
//       PropertyEntity pe=new PropertyEntity();
//       pe.setTitle(propertyDto.getTitle());
//       pe.setAddress(propertyDto.getAddress());
//       pe.setDescription(propertyDto.getDescription());
//       pe.setOwnerName(propertyDto.getOwnerName());
//       pe.setPrice(propertyDto.getPrice());
//       pe.setOwnerEmail(propertyDto.getOwnerEmail());
        PropertyEntity pe=propertyconverter.ConvertDTOtoEntity(propertyDto);
        propertyRepository.save(pe);
        propertyDto=propertyconverter.ConvertEntitytoDto(pe);
        return null;
    }

    @Override
    public List<PropertyDto> getAllProperties() {

        List<PropertyEntity> listOfProps=(List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDto> propList=new ArrayList<>();
        for(PropertyEntity pe: listOfProps){
            PropertyDto dto=propertyconverter.ConvertEntitytoDto(pe);
            propList.add(dto);
        }
        return propList;
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId) {
        //optional is used for nice nullcheck
        Optional<PropertyEntity> optEn=propertyRepository.findById(propertyId);
        PropertyDto dto=null;
        if(optEn.isPresent())
        {
            PropertyEntity pe=optEn.get();
            pe.setTitle(propertyDto.getTitle());
            pe.setAddress(propertyDto.getAddress());
            pe.setDescription(propertyDto.getDescription());
            pe.setOwnerName(propertyDto.getOwnerName());
            pe.setPrice(propertyDto.getPrice());
            pe.setOwnerEmail(propertyDto.getOwnerEmail());
            dto=propertyconverter.ConvertEntitytoDto(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public PropertyDto updatePropertyPrice(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEn=propertyRepository.findById(propertyId);
        PropertyDto dto=null;
        if(optEn.isPresent())
        {
            PropertyEntity pe=optEn.get();

            pe.setPrice(propertyDto.getPrice());

            dto=propertyconverter.ConvertEntitytoDto(pe);
            propertyRepository.save(pe);

        }
        return dto;

    }

    @Override
    public PropertyDto updatePropertyDescription(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEn=propertyRepository.findById(propertyId);
        PropertyDto dto=null;
        if(optEn.isPresent())
        {
            PropertyEntity pe=optEn.get();

            pe.setDescription(propertyDto.getDescription());

            dto=propertyconverter.ConvertEntitytoDto(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyID) {
        propertyRepository.deleteById((propertyID));
    }


}
