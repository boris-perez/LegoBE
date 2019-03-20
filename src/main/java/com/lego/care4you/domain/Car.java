package com.lego.care4you.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Alan.
 */
@Getter
@Setter
@Document
public class Car extends DomainBase {
    private String brand;
    private long year;
    private String model;
    private String color;
    private String imageUrl;
}
