package com.rob.gersgarage.repository;

import com.rob.gersgarage.model.VehicleParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclePartsRepository extends JpaRepository<VehicleParts, Long> {

}
