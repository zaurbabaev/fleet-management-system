package com.kindsonthegenius.fleetms.parameters.repositories;

import com.kindsonthegenius.fleetms.parameters.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
