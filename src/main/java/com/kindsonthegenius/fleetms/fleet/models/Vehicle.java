package com.kindsonthegenius.fleetms.fleet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kindsonthegenius.fleetms.hr.models.Employee;
import com.kindsonthegenius.fleetms.parameters.models.Location;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id", insertable = false, updatable = false)
    VehicleType vehicleType;

    @Column(name = "vehicle_type_id")
    Integer vehicleTypeId;

    String vehicleNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date registrationDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date acquisitionDate;
    String description;

    @ManyToOne
    @JoinColumn(name = "vehicle_make_id", insertable = false, updatable = false)
    VehicleMake vehicleMake;
    @Column(name = "vehicle_make_id")
    Integer vehicleMakeId;

    String power;
    String fuelCapacity;

    @ManyToOne
    @JoinColumn(name = "vehicle_status_id", insertable = false, updatable = false)
    VehicleStatus vehicleStatus;
    @Column(name = "vehicle_status_id")
    Integer vehicleStatusId;

    String netWeight;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    Employee inCharge;
    @Column(name = "employee_id")
    Integer employeeId;

    @ManyToOne
    @JoinColumn(name = "vehicle_model_id", insertable = false, updatable = false)
    VehicleModel vehicleModel;
    @Column(name = "vehicle_model_id")
    Integer vehicleModelId;

    @ManyToOne
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    Location currentLocation;
    @Column(name = "location_id")
    Integer locationId;

    String remarks;

}
