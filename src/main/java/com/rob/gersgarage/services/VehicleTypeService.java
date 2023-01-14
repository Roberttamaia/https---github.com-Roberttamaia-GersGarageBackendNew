package com.rob.gersgarage.services;
import com.rob.gersgarage.model.VehicleType;
import com.rob.gersgarage.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;


    public VehicleType saveVehicleType(VehicleType vehicleType){
        return vehicleTypeRepository.save(vehicleType);
    }

    public List<VehicleType> getVehicleType(){
        return vehicleTypeRepository.findAll();
    }

    public VehicleType getVehicleTypeById(Long id){
        return vehicleTypeRepository.findById(id).orElse(null);
    }


    public String deleteVehicleType(Long id){
        vehicleTypeRepository.deleteById(id);
        return "Vehicle Type has been deleted" +id;
    }

    public VehicleType updateVehicleType(VehicleType vehicleType){
        VehicleType existingVehicleType=vehicleTypeRepository.findById(vehicleType.getId()).orElse(null);
        existingVehicleType.setMake(vehicleType.getMake());
        existingVehicleType.setModel(vehicleType.getModel());
        return vehicleTypeRepository.save(existingVehicleType);
    }
}
