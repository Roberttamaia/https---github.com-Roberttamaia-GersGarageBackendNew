package com.rob.gersgarage.services;

import com.rob.gersgarage.model.Vehicles;
import com.rob.gersgarage.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesService {
    @Autowired
    private VehiclesRepository vehiclesRepository;

    public Vehicles saveVehicle(Vehicles vehicles){
        return vehiclesRepository.save(vehicles);
    }

    public List<Vehicles> getVehicles(){
        return vehiclesRepository.findAll();
    }
    public Vehicles getVehicleById(Long id){
        return vehiclesRepository.findById(id).orElse(null);
    }


    public String deleteVehicle(Long id){
        vehiclesRepository.deleteById(id);
        return "Vehicle has been deleted" +id;
    }

    public Vehicles updateVehicle(Vehicles vehicles){
        Vehicles existingVehicle=vehiclesRepository.findById(vehicles.getId()).orElse(null);

        existingVehicle.setEngine(vehicles.getEngine());
        existingVehicle.setLicense(vehicles.getLicense());
        existingVehicle.setUsers(vehicles.getUsers());
        existingVehicle.setVehicleType(vehicles.getVehicleType());
        return vehiclesRepository.save(existingVehicle);
    }


















}
