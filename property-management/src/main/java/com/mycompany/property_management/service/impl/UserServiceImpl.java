package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.Repository.UserRepository;
import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.exception.BuisnessException;
import com.mycompany.property_management.exception.ErrorModal;
import com.mycompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity=userConverter.convertDTOtoEntity(userDTO);
        Optional<UserEntity> optionaluserEntity=  userRepository.findByEmail(userEntity.getEmail());
        if(optionaluserEntity.isPresent()) {
            List<ErrorModal> errorModeList=new ArrayList<>();
            ErrorModal errorModel=new ErrorModal();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("user is already registered with this email");
            errorModeList.add(errorModel);

            throw new BuisnessException(errorModeList);

        }
        else{
            userEntity=userRepository.save(userEntity);
            userDTO=userConverter.convertEntitytoDTO(userEntity);
            return userDTO;
        }

    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO=null;
     Optional<UserEntity> optionaluserEntity=  userRepository.findByEmailAndPassword(email, password);
     if(optionaluserEntity.isPresent())
     {
       userDTO=userConverter.convertEntitytoDTO(optionaluserEntity.get()) ;

     }else{
         List<ErrorModal> errorModeList=new ArrayList<>();
         ErrorModal errorModel=new ErrorModal();
         errorModel.setCode("INVALID_LOGIN");
         errorModel.setMessage("Imcorrect Email or password");
         errorModeList.add(errorModel);

         throw new BuisnessException(errorModeList);
     }
     return userDTO;
    }
}
