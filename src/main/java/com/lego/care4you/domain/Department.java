package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author rveizaga
 */
@Getter
@Setter
@Document
public class Department extends GenericDomain {

    private String code;
    private String name;
}
