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
public class Company extends GenericDomain {

    private String code;
    private String name;
    private String instructor;

    @DBRef
    private Department department;
}
