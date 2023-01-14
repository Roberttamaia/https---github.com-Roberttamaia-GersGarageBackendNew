package com.rob.gersgarage.controller;
import com.rob.gersgarage.model.VehicleParts;
import com.rob.gersgarage.model.VehicleType;
import com.rob.gersgarage.services.VehiclePartsService;
import com.rob.gersgarage.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class VehiclePartsController {

    @Autowired
    private VehiclePartsService vehiclePartsService;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;


    @PostMapping("/addVehiclePart")
    public VehicleParts vehicleParts(@RequestBody Map <String, Object> vehicleParts){
        VehicleType vehicleType = vehicleTypeRepository.findById(Long.valueOf(vehicleParts.get("vehicleType").toString())).get();
        VehicleParts vehicleParts1 = new VehicleParts();
        vehicleParts1.setVehicleType(vehicleType);
        vehicleParts1.setName(vehicleParts.get("name").toString());
        vehicleParts1.setPricing((Integer) vehicleParts.get("pricing"));
        return vehiclePartsService.saveVehiclePart(vehicleParts1);
    }
    @GetMapping("/listVehicleParts")
    public List<VehicleParts> findAllVehicleParts(){
        return vehiclePartsService.getVehiclePart();
    }

    @GetMapping("/findVehiclePartById/{id}")
    public VehicleParts findVehiclePartById(@PathVariable Long id){
        return vehiclePartsService.getVehiclePartById(id);
    }
    @PutMapping("/updateVehiclePart")
    public VehicleParts updateVehiclePart(@RequestBody VehicleParts vehicleParts){
        return vehiclePartsService.updateVehiclePart(vehicleParts);
    }
    @DeleteMapping("/deleteVehiclePart/{id}")
    public String deleteInvoice(@PathVariable Long id){
        return vehiclePartsService.deleteVehiclePart(id);
    }
}
