package com.backendbigdata.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Vendor {

    @Id
    @Column(name = "vendNum")
    String vendNum;

    String name;
}
