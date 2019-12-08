package com.backendbigdata.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Part {

    @Id
    @Column(name = "pId")
    String pId;
    String description;
    String stockUnit;
    Double unitWeight;
    Double price;
    String cacit;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    Category category;

    @ManyToOne
    @JoinColumn(name = "cooId")
    CountryOfOrigin countryOfOrigin;

}
