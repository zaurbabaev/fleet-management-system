package com.kindsonthegenius.fleetms.security.models;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PROTECTED)
public class Auditable<U> {


    @CreatedBy
    U createdBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    Date createdDate;

    @LastModifiedBy
    U lastModifiedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    Date lastModifiedDate;


}
