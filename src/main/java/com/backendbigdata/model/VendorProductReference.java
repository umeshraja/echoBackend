package com.backendbigdata.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class VendorProductReference implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "vendNum")
    Vendor vendor;

    @Id
    @ManyToOne
    @JoinColumn(name = "partId")
    Part part;

    String costUnit;
}
