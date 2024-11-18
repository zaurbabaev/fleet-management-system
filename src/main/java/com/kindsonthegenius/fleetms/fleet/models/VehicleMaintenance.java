package com.kindsonthegenius.fleetms.fleet.models;


import com.kindsonthegenius.fleetms.parameters.models.Supplier;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class VehicleMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    Vehicle vehicle;
    @Column(name = "vehicel_id")
    Integer vehicleId;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date endDate;

    String price;

    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    Supplier supplier;
    @Column(name = "supplier_id")
    Integer supplierId;

    String remarks;


}
