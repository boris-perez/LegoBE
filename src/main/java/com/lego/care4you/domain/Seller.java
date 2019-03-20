package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Alan.
 */
@Getter
@Setter
@Document
public class Seller extends GenericDomain {
    @Id
    private String id;
    private String name;
    private long age;
    private long ci;
    private long numCarsSold;
}
