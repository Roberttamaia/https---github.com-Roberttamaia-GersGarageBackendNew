package com.rob.gersgarage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleParts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Integer pricing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    private VehicleType vehicleType;




        @ManyToMany(mappedBy = "vehicleParts")
        private Set<Invoice> invoices;



//
//
//    @ManyToMany(mappedBy = "vehicleParts")
//    private Set<Invoice> members = new HashSet<>();
}
