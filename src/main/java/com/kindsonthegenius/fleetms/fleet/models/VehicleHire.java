package com.kindsonthegenius.fleetms.fleet.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kindsonthegenius.fleetms.parameters.models.Client;
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
public class VehicleHire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    Vehicle vehicle;
    @Column(name = "vehicle_id")
    Integer vehicleId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateOut;
    String timeOut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateIn;

    String timeIn;

    @ManyToOne
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    Location location;
    @Column(name = "location_id")
    Integer locationId;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    Client client;
    @Column(name = "client_id")
    Integer clientId;

    String price;
    String remarks;

}
