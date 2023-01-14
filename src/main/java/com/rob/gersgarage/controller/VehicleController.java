package com.rob.gersgarage.controller;

import com.rob.gersgarage.model.Users;
import com.rob.gersgarage.model.VehicleType;
import com.rob.gersgarage.model.Vehicles;
import com.rob.gersgarage.services.VehiclesService;
import com.rob.gersgarage.repository.UsersRepository;
import com.rob.gersgarage.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class VehicleController {


    @Autowired
    private VehiclesService vehiclesService;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @PostMapping("/addVehicle")
    public Vehicles addVehicle(@RequestBody Map <String, Object> vehicles){
        System.out.println(vehicles.get("users"));
        Users user = usersRepository.findById(Long.valueOf(vehicles.get("users").toString())).get();
        Vehicles vehicles1 = new Vehicles();
        VehicleType vehicleType = vehicleTypeRepository.findById(Long.valueOf(vehicles.get("vehicleType").toString())).get();
        vehicles1.setVehicleType(vehicleType);
        vehicles1.setEngine(vehicles.get("engine").toString());
        vehicles1.setLicense(vehicles.get("license").toString());
        vehicles1.setUsers(user);
        return vehiclesService.saveVehicle(vehicles1);
    }

    @GetMapping("/listVehicles")
    public List<Vehicles> findAllVehicles(){
        return vehiclesService.getVehicles();
    }
    @GetMapping("/listVehiclesById/{id}")
    public Vehicles findVehicleById(@PathVariable Long id){
        return vehiclesService.getVehicleById(id);
    }
    @PutMapping("/updateVehicles")
    public Vehicles updateVehicle(@RequestBody Vehicles vehicles){
        return vehiclesService.updateVehicle(vehicles);
    }
    @DeleteMapping("/deleteVehicle/{id}")
    public String deleteVehicle(@PathVariable Long id){
        return vehiclesService.deleteVehicle(id);
    }
}
