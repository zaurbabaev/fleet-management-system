package com.kindsonthegenius.fleetms.fleet.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
public class VehicleMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    Vehicle vehicle;
    @Column(name = "vehicel_id")
    Integer vehicleId;

    @ManyToOne
    @JoinColumn(name = "location_id1", insertable = false, updatable = false)
    Location location1;
    @Column(name = "location_id1")
    Integer location_id1;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date1;

    @ManyToOne
    @JoinColumn(name = "location_id2", insertable = false, updatable = false)
    Location location2;
    @Column(name = "location_id2")
    Integer location_id2;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date2;

    String remarks;

}
