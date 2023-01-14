package com.rob.gersgarage.controller;

import com.rob.gersgarage.model.Booked;
import com.rob.gersgarage.services.BookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BookedController {
    @Autowired
    private BookedService bookedService;


    @PostMapping("/addBooked")
    public Booked addBooked(@RequestBody Booked booked){
        return bookedService.saveBooked(booked);
    }

    @GetMapping("/listBooked")
    public List<Booked> findAllBooked(){
        return bookedService.getBooked();
    }

}
