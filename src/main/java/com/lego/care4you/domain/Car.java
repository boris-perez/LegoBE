package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Alan.
 */
@Getter
@Setter
@Document
public class Car extends GenericDomain {
    private String brand;
    private long year;
    private String model;
    private String color;
    private String imageUrl;
}
