package com.berezovska.autoria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "category_brand")
public @Data
class CategoryBrandPair extends BaseEntity {

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;


/*    @OneToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "category_brand_model",
            joinColumns = @JoinColumn(name = "category_brand_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id"))
    private Set<Model> models;*/

}