package com.rob.gersgarage.controller;
import com.rob.gersgarage.model.Bookings;
import com.rob.gersgarage.model.Services;
import com.rob.gersgarage.model.Vehicles;
import com.rob.gersgarage.services.BookingsService;
import com.rob.gersgarage.model.*;
import com.rob.gersgarage.repository.ServicesRepository;
import com.rob.gersgarage.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class BookingController {

    @Autowired
    private BookingsService bookingsService;
    @Autowired
    private VehiclesRepository vehiclesRepository;
    @Autowired
    private ServicesRepository servicesRepository;


    @PostMapping("/addBooking")
    public Bookings addBooking(@RequestBody Map<String, Object> bookings){
        System.out.println(bookings.get("vehicles"));
        Vehicles vehicles = vehiclesRepository.findById(Long.valueOf(bookings.get("vehicles").toString())).get();
        Bookings bookings1  = new Bookings();
        Services services = servicesRepository.findById(Long.valueOf(bookings.get("services").toString())).get();
        bookings1.setServices(services);
        bookings1.setStartTime((Date) bookings.get("startTime"));
        bookings1.setEndTime((Date) bookings.get("endTime"));
        bookings1.setDescription(bookings.get("description").toString());
        bookings1.setVehicle(vehicles);
        return bookingsService.saveBooking(bookings1);
    }

    @GetMapping("/bookings")
    public List<Bookings> findAllBookings(){
        return bookingsService.getBooking();
    }

    @GetMapping("/getBookingById/{id}")
    public Bookings findBookingById(@PathVariable Long id){
        return bookingsService.getBookingById(id);
    }

    @PutMapping("/updateBooking")
    public Bookings updateBooking(@RequestBody Bookings bookings){
        return bookingsService.updateBooking(bookings);
    }
    @DeleteMapping("/deleteBooking/{id}")
    public String deleteBooking(@PathVariable Long id){
        return bookingsService.deleteBooking(id);
    }

}
