//@formatter:off
/**
 *  $$Id$$
 *       . * .
 *     * RRRR  *    Copyright (c) 2018 EUIPO: European Union Intellectual
 *   .   RR  R   .  Property Office (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 */
//@formatter:on
package com.jskno.cryptocoinsbe.domain;

import com.jskno.cryptocoinsbe.domain.base.AbstractEntity;
import com.jskno.cryptocoinsbe.domain.constraints.ExchangeWebConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by Jose on 03/02/18.
 */
@Entity
@ExchangeWebConstraint
public class ExchangeWeb extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "The ExchangeWeb name is required")
    private String name;

    @Column(name = "url")
    @NotBlank(message = "The ExchangeWeb url is required")
    private String url;

    public ExchangeWeb() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
