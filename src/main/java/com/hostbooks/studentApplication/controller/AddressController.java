package com.hostbooks.studentApplication.controller;

import com.hostbooks.studentApplication.entities.Address;
import com.hostbooks.studentApplication.service.AddressService;
import com.hostbooks.studentApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students/{empId}/address")
public class AddressController {

    @Autowired
    private AddressService aService;

    @Autowired
    private StudentService sService;


    @PostMapping("/")
    ResponseEntity<String> createAddressByStudentIdController(@Valid @RequestBody Address add ,
                                                             @PathVariable("stdId") Integer Id){

        String message =  aService.createAddressById(add, Id);

        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }


    @GetMapping("/")
    ResponseEntity<List<Address>> getAllAddressByStudentIddController(@PathVariable("stdId") Integer Id){

        List<Address> stds =  aService.getAllAddressByStudentId(Id);

        return new ResponseEntity<List<Address>>(stds, HttpStatus.ACCEPTED);
    }




    @GetMapping("/{Id}")
    ResponseEntity<Address> getAddressByIdController(@PathVariable("stdId") Integer Id, @PathVariable("Id") Integer  addId){

        Address stds =   aService.getAddressByAddressId(Id, addId);

        return new ResponseEntity<Address>(stds, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/{Id}")
    ResponseEntity<String> deleteAddressByIdController(@PathVariable("stdId") Integer Id, @PathVariable("Id") Integer addId){
        String mess =  aService.deleteAddressById(Id, addId);
        return new ResponseEntity<String>(mess, HttpStatus.ACCEPTED);
    }
}
