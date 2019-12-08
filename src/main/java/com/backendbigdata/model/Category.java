package com.backendbigdata.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Category")
@Table(name = "Category")
public class Category {

    @Id
    Integer cId;

    String name;

}
