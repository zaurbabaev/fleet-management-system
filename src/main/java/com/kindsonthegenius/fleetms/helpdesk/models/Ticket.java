package com.kindsonthegenius.fleetms.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kindsonthegenius.fleetms.hr.models.Employee;
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
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String subject;
    String details;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date openDate;

    @ManyToOne
    @JoinColumn(name = "ticket_status_id", insertable = false, updatable = false)
    TicketStatus ticketStatus;
    @Column(name = "ticket_status_id")
    Integer ticketStatusId;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    Employee raisedBy;
    @Column(name = "employee_id")
    Integer employeeId;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    Employee asignedTo;

    String remarks;

}
