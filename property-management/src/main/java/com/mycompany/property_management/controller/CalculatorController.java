package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.CalculatorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") //class level mapping of url to a controller class

public class CalculatorController {

    @GetMapping("/add/{num3}")//this is method level mapping of a url to a controller function.
//http://localhost:8089/api/v1/calculator/add?num1=9.0&num2=8.9
    //we acn use both at the same time
    //with the help of request param we were able to send data to server receive back the information
    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2,@PathVariable Double num3){
        return num1+num2;
    }
    @GetMapping("/sub/{num1}/{num2}")//2nd mathod to pass information a variable by path variable
    //http://localhost:8089/api/v1/calculator/sub/9.0/10.0
    public Double substarct(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
        Double result=null;
        if(num1>num2)
        {
            result=num1-num2;
        }
        else{
            result= num2-num1;
        }
return result;
    }
    @PostMapping("/mul")
    //whatever we will pass it will be mapped to calculatorDto
    //http://localhost:8089/api/v1/calculator/mul
    //Json {
    //    "num1":7.0,
    //    "num2":9.0,
    //    "num3":8.0,
    //    "num41":6.0
    //}
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDto calculatorDto){
        Double result=null;
        result=calculatorDto.getNum1()*calculatorDto.getNum2()*calculatorDto.getNum3()*calculatorDto.getNum4();
        //to cfreate response according to pur need response entity is used.
        ResponseEntity<Double> responseEntity=new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }

}
