package com.rob.gersgarage.controller;
import com.rob.gersgarage.model.Services;
import com.rob.gersgarage.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class ServicesController {
    @Autowired
    private ServicesService servicesService;


    @PostMapping("/addService")
    public Services addService(@RequestBody Services services){
        return servicesService.saveService(services);
    }

    @GetMapping("/listServices")
    public List<Services> findAllServices(){
        return servicesService.getServices();
    }
    @GetMapping("/listServiceById/{id}")
    public Services findServiceById(@PathVariable Long id){
        return servicesService.getServiceById(id);
    }
    @PutMapping("/updateServices")
    public Services updateService(@RequestBody Services services){
        return servicesService.updateService(services);
    }
    @DeleteMapping("/deleteService/{id}")
    public String deleteService(@PathVariable Long id){
        return servicesService.deleteService(id);
    }

}
