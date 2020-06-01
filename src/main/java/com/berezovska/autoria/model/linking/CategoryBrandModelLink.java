package com.berezovska.autoria.model.linking;

import com.berezovska.autoria.model.BaseEntity;
import com.berezovska.autoria.model.Brand;
import com.berezovska.autoria.model.Category;
import com.berezovska.autoria.model.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "category_brand_model")
public @Data
class CategoryBrandModelLink extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "model_id")
    private Model model;

    public CategoryBrandModelLink(int id, Category category, Brand brand, Model model) {
        this.setId(id);
        this.category = category;
        this.brand = brand;
        this.model = model;

    }
}