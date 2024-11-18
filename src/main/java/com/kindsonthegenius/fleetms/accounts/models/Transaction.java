package com.kindsonthegenius.fleetms.accounts.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kindsonthegenius.fleetms.hr.models.Employee;
import com.kindsonthegenius.fleetms.parameters.models.Client;
import com.kindsonthegenius.fleetms.parameters.models.Contact;
import com.kindsonthegenius.fleetms.parameters.models.Supplier;
import javax.persistence.*;
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
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    double amount;
    String purpose;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "transaction_status_id", insertable = false, updatable = false)
    TransactionStatus transactionStatus;
    @Column(name = "transaction_status_id")
    Integer transactionStatusId;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id", insertable = false, updatable = false)
    TransactionType transactionType;
    @Column(name = "transaction_type_id")
    Integer transactionTypeId;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    Client client;
    @Column(name = "client_id")
    Integer clientId;

    @ManyToOne
    @JoinColumn(name = "contact_id", insertable = false, updatable = false)
    Contact contact;
    @Column(name = "contact_id")
    Integer contactId;

    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    Supplier supplier;
    @Column(name = "supplier_id")
    Integer supplierId;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    Employee approvedBy;
    @Column(name = "employee_id")
    Integer employeeId;

    String remarks;
}
