package com.kindsonthegenius.fleetms.accounts.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kindsonthegenius.fleetms.parameters.models.Client;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "invoice_status_id", insertable = false, updatable = false)
    InvoiceStatus invoiceStatus;
    @Column(name = "invoice_status_id")
    Integer invoiceStatusId;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    Client client;
    @Column(name = "client_id")
    Integer clientId;

    String remarks;

}
