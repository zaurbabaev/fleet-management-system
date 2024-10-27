package com.kindsonthegenius.fleetms.parameters.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Location extends CommonObject {

    String city;
    String address;

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
}
