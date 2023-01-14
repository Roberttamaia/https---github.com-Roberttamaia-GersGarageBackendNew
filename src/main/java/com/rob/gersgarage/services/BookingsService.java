package com.rob.gersgarage.services;

import com.rob.gersgarage.model.Bookings;
import com.rob.gersgarage.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {
    @Autowired
    private BookingsRepository bookingsRepository;


    public Bookings saveBooking(Bookings booking){
        return bookingsRepository.save(booking);
    }

    public List<Bookings> getBooking(){
        return bookingsRepository.findAll();
    }

    public Bookings getBookingById(Long id){
        return bookingsRepository.findById(id).orElse(null);
    }


    public String deleteBooking(Long id){
        bookingsRepository.deleteById(id);
        return "Booking has been deleted" +id;
    }

    public Bookings updateBooking(Bookings bookings){
        Bookings existingBookings=bookingsRepository.findById(bookings.getId()).orElse(null);
        existingBookings.setStartTime(bookings.getStartTime());
        existingBookings.setEndTime(bookings.getEndTime());
        existingBookings.setDescription(bookings.getDescription());
        existingBookings.setServices(bookings.getServices());
        existingBookings.setVehicle(bookings.getVehicle());
        return bookingsRepository.save(existingBookings);
    }


}
