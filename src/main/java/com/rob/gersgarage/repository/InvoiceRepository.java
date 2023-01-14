package com.rob.gersgarage.repository;


import com.rob.gersgarage.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository <Invoice, Long> {
}
