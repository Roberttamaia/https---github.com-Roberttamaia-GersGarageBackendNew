package com.rob.gersgarage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date startTime;
    private Date endTime;
    private String Description;

    @ManyToOne
    private Services services;


    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicle;

}