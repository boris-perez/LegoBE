package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author rveizaga
 */
@Getter
@Setter
@Document
public class Rules extends GenericDomain {

    private String state;

    @DBRef
    private Company company;
}
