package com.berezovska.autoria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "category_body")
public @Data
class CategoryBodyLink extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "body_id")
    private Body body;

    public CategoryBodyLink(int id, Category category, Body body) {
        this.setId(id);
        this.body = body;
        this.category = category;
    }
}