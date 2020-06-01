package com.berezovska.autoria.model.linking;

import com.berezovska.autoria.model.BaseEntity;
import com.berezovska.autoria.model.Category;
import com.berezovska.autoria.model.Gearbox;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "category_gearbox")
public @Data
class CategoryGearboxLink extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "gearbox_id")
    private Gearbox gearbox;

    public CategoryGearboxLink(int id, Category category, Gearbox gearbox) {
        this.setId(id);
        this.gearbox = gearbox;
        this.category = category;
    }
}
