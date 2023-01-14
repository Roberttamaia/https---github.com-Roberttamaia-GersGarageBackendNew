package com.rob.gersgarage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String engine;
    private String license;

    @ManyToOne
    private Users users;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleType_id")
    private VehicleType vehicleType;

//    @OneToMany(mappedBy = "vehicle")
//    private List<Bookings> bookings;
}
