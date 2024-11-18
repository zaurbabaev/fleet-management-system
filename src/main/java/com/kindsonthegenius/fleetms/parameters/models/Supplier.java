package com.kindsonthegenius.fleetms.parameters.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;

    String name;
    String address;
    String city;
    String phone;
    String mobile;
    String website;
    String email;

    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    Country country;
    @Column(name = "country_id")
    Integer countryId;

    @ManyToOne
    @JoinColumn(name = "state_id", insertable = false, updatable = false)
    State state;
    @Column(name = "state_id")
    Integer stateId;

    String details;

}
