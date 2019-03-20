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
public class Buyer extends DomainBase {
    private String name;
    private String ci;
    private String profession;
    private long cellphone;
}
