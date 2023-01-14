package com.rob.gersgarage.repository;

import com.rob.gersgarage.model.Booked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedRepository extends JpaRepository <Booked, Long> {

}
