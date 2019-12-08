package com.backendbigdata.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COO")
public class CountryOfOrigin {

    @Id
    @Column(name = "cooId")
    String cooId;

    String name;
}
