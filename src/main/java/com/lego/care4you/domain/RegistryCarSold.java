package com.lego.care4you.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Alan
 */
@Getter
@Setter
@Document
public class RegistryCarSold extends DomainBase {
    private Date sellDate;
    @DBRef
    private Seller seller;
    @DBRef
    private Buyer buyer;
    @DBRef
    private Car car;
}
