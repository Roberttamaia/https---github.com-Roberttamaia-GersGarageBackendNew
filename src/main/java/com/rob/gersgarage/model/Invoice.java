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
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer totalAmount;
    private Integer paidAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookings_id")
    private Bookings bookings;

    @ManyToMany
    private Set<VehicleParts> vehicleParts;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "invoice_parts",
//            joinColumns = @JoinColumn(name = "invoice_id"),
//            inverseJoinColumns = @JoinColumn(name = "vehicleParts_id")
//    )
//    private Set<VehicleParts> vehicleParts = new HashSet<>();

}
