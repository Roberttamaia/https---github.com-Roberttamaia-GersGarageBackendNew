package com.rob.gersgarage.services;

import com.rob.gersgarage.model.Services;
import com.rob.gersgarage.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    public Services saveService(Services services){
        return servicesRepository.save(services);
    }


    public List<Services> getServices(){
        return servicesRepository.findAll();
    }

    public Services getServiceById(Long id){
        return servicesRepository.findById(id).orElse(null);
    }

    public String deleteService(Long id){
        servicesRepository.deleteById(id);
        return "Service has been deleted" +id;
    }

    public Services updateService(Services services){
        Services existingService=servicesRepository.findById(services.getId()).orElse(null);
        existingService.setServiceName(services.getServiceName());
        existingService.setWeight(services.getWeight());
        return servicesRepository.save(existingService);
    }
}
