package com.rob.gersgarage.services;

import com.rob.gersgarage.model.VehicleParts;
import com.rob.gersgarage.repository.VehiclePartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclePartsService {
    @Autowired
    private VehiclePartsRepository vehiclePartsRepository;
    public VehicleParts saveVehiclePart(VehicleParts vehicleParts){
        return vehiclePartsRepository.save(vehicleParts);
    }

    public List<VehicleParts> getVehiclePart(){
        return vehiclePartsRepository.findAll();
    }

    public VehicleParts getVehiclePartById(Long id){
        return vehiclePartsRepository.findById(id).orElse(null);
    }


    public String deleteVehiclePart(Long id){
        vehiclePartsRepository.deleteById(id);
        return "Vehicle Part has been deleted" +id;
    }

    public VehicleParts updateVehiclePart(VehicleParts vehicleParts){
        VehicleParts existingVehiclePart=vehiclePartsRepository.findById(vehicleParts.getId()).orElse(null);
        existingVehiclePart.setName(vehicleParts.getName());
        existingVehiclePart.setPricing(vehicleParts.getPricing());
        existingVehiclePart.setVehicleType(vehicleParts.getVehicleType());
        return vehiclePartsRepository.save(existingVehiclePart);
    }

}
