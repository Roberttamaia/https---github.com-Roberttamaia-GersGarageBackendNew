package com.rob.gersgarage.repository;

import com.rob.gersgarage.model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehiclesRepository extends JpaRepository <Vehicles, Long> {
}
