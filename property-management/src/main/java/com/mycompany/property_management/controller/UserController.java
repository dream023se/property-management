package com.mycompany.property_management.controller;


import com.mycompany.property_management.dto.PropertyDto;
import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.service.PropertyService;
import com.mycompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
       userDTO= userService.register((userDTO));
        ResponseEntity<UserDTO> responseEntity= new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        userDTO= userService.login(userDTO.getEmail(),userDTO.getPassword());
        ResponseEntity<UserDTO> responseEntity= new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }
}
