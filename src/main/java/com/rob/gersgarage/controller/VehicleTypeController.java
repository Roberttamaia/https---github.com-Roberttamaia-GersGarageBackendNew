package com.rob.gersgarage.controller;
import com.rob.gersgarage.model.VehicleType;
import com.rob.gersgarage.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;


    @PostMapping("/addVehicleType")
    public VehicleType addVehiclePart(@RequestBody VehicleType vehicleType){
        return vehicleTypeService.saveVehicleType(vehicleType);
    }

    @GetMapping("/listVehicleTypes")
    public List<VehicleType> findAllVehicleParts(){
        return vehicleTypeService.getVehicleType();
    }

    @GetMapping("/findVehicleTypeById/{id}")
    public VehicleType findVehiclePartById(@PathVariable Long id){
        return vehicleTypeService.getVehicleTypeById(id);
    }
    @PutMapping("/updateVehicleType")
    public VehicleType updateVehicleType(@RequestBody VehicleType vehicleType){
        return vehicleTypeService.updateVehicleType(vehicleType);
    }
    @DeleteMapping("/deleteVehicleType/{id}")
    public String deleteVehicleType(@PathVariable Long id){
        return vehicleTypeService.deleteVehicleType(id);
    }

}
