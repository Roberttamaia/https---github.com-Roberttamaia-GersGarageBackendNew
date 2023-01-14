package com.rob.gersgarage.controller;

import com.rob.gersgarage.model.Bookings;
import com.rob.gersgarage.model.Invoice;
import com.rob.gersgarage.model.VehicleParts;
import com.rob.gersgarage.services.InvoiceService;
import com.rob.gersgarage.model.*;
import com.rob.gersgarage.repository.BookingsRepository;
import com.rob.gersgarage.repository.VehiclePartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")

public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private BookingsRepository bookingsRepository;

    @Autowired
    private VehiclePartsRepository vehiclePartsRepository;


    @PostMapping("/addInvoice")
    public Invoice addInvoice(@RequestBody Map <String, Object> invoice){
        System.out.println(invoice.get("bookings"));
        Bookings bookings  = bookingsRepository.findById(Long.valueOf(invoice.get("bookings").toString())).get();
        Invoice invoice1 = new Invoice();
        VehicleParts vehicleParts = vehiclePartsRepository.findById(Long.valueOf(invoice.get("vehicleParts").toString())).get();
    //    invoice1.setVehicleParts((Set<VehicleParts>) invoice.get("vehicleParts"));
        invoice1.setTotalAmount((Integer) invoice.get("TotalAmount"));
        invoice1.setPaidAmount((Integer) invoice.get("PaidAmount"));
        invoice1.setBookings(bookings);
        return invoiceService.saveInvoice(invoice1);
    }



    @GetMapping("/listInvoices")
    public List<Invoice> findAllServices(){
        return invoiceService.getInvoices();
    }
    @GetMapping("/listInvoiceById/{id}")
    public Invoice findInvoiceById(@PathVariable Long id){
        return invoiceService.getInvoiceById(id);
    }
    @PutMapping("/updateInvoice")
    public Invoice updateInvoice(@RequestBody Invoice invoice){
        return invoiceService.updateInvoice(invoice);
    }
    @DeleteMapping("/deleteInvoice/{id}")
    public String deleteInvoice(@PathVariable Long id){
        return invoiceService.deleteInvoice(id);
    }
}
