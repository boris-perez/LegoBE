package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author rveizaga
 */
@Getter
@Setter
@Document
public class Position extends GenericDomain {

    private String code;
    private String name;
    private String description;
}
