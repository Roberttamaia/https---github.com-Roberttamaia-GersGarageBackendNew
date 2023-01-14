package com.rob.gersgarage.repository;

import com.rob.gersgarage.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends JpaRepository <Bookings, Long> {
}
