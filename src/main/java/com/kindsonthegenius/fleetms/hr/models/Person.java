package com.kindsonthegenius.fleetms.hr.models;


import com.kindsonthegenius.fleetms.parameters.models.Country;
import com.kindsonthegenius.fleetms.parameters.models.State;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String firstname;
    String lastname;
    String othername;

    @Formula(value = " concat(firstname,' ', lastname) ")
    String fullName;

    String title;
    String initials;
    String socialSecurityNumber;
    String gender;
    String maritalStatus;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateOfBirth;
    String city;
    String address;
    String phone;
    String mobile;
    String email;
    String photo;

}
