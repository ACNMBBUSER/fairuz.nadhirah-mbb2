package com.fairuznadhirah.productprofile.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productprofile") //will be created in database
@ApiModel(description = "This table for product information")
public class ProductProfile {

    @Id
    private String id;
    private String name;
    private String price;
    private String description;

    public ProductProfile() {
    }

    public ProductProfile(String id, String name, String price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
