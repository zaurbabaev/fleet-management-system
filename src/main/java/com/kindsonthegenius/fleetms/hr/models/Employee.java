package com.kindsonthegenius.fleetms.hr.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person {

    @ManyToOne
    @JoinColumn(name = "employee_type_id", insertable = false, updatable = false)
    EmployeeType employeeType;
    @Column(name = "employee_type_id")
    Integer employeeTypeId;

    String photo;
    String username;

    @ManyToOne
    @JoinColumn(name = "job_title_id", insertable = false, updatable = false)
    JobTitle jobTitle;
    @Column(name = "job_title_id")
    Integer jobTitleId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date hireDate;

}
