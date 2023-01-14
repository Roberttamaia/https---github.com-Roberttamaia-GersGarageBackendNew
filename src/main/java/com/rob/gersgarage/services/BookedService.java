package com.rob.gersgarage.services;

import com.rob.gersgarage.model.Booked;
import com.rob.gersgarage.repository.BookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedService {


    @Autowired
    private BookedRepository bookedRepository;


    public Booked saveBooked(Booked booked){
        return bookedRepository.save(booked);
    }

    public List<Booked> getBooked(){
        return bookedRepository.findAll();
    }

    public Booked getBookedById(Long id){
        return bookedRepository.findById(id).orElse(null);
    }


    public String deleteBooked(Long id){
        bookedRepository.deleteById(id);
        return "Booked has been deleted" +id;
    }

    public Booked updateBooked(Booked booked){
        Booked existingBooked=bookedRepository.findById(booked.getId()).orElse(null);
        existingBooked.setFirstName(booked.getFirstName());
        existingBooked.setLastName(booked.getLastName());
        existingBooked.setContact(booked.getContact());
        existingBooked.setVehicleType(booked.getVehicleType());
        existingBooked.setVehicleMake(booked.getVehicleMake());
        existingBooked.setEngine(booked.getEngine());
        existingBooked.setLicense(booked.getLicense());
        existingBooked.setDescription(booked.getDescription());
        existingBooked.setDate(booked.getDate());
        return bookedRepository.save(existingBooked);
    }
}
