package com.rob.gersgarage.services;

import com.rob.gersgarage.model.Invoice;
import com.rob.gersgarage.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }


    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id){
        return invoiceRepository.findById(id).orElse(null);
    }

    public String deleteInvoice(Long id){
        invoiceRepository.deleteById(id);
        return "Invoice has been deleted" +id;
    }

    public Invoice updateInvoice(Invoice invoice){
        Invoice existingInvoice=invoiceRepository.findById(invoice.getId()).orElse(null);
        existingInvoice.setBookings(invoice.getBookings());
        existingInvoice.setVehicleParts(invoice.getVehicleParts());
        existingInvoice.setPaidAmount(invoice.getPaidAmount());
        existingInvoice.setTotalAmount(invoice.getTotalAmount());
        return invoiceRepository.save(existingInvoice);
    }
}
