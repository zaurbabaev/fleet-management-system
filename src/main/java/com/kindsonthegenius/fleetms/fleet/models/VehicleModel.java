package com.kindsonthegenius.fleetms.fleet.models;

import com.kindsonthegenius.fleetms.parameters.models.CommonObject;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class VehicleModel extends CommonObject {

}
