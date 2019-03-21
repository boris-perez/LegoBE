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
@Deprecated
public class Buyer extends GenericDomain {
    private String name;
    private String ci;
    private String profession;
    private long cellphone;
}
