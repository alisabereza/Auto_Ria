package com.berezovska.autoria.model;

import com.berezovska.autoria.model.linking.CategoryGearboxLink;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "gearbox")
public @Data
class Gearbox extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<CategoryGearboxLink> categoryGearboxLinks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gearbox gearbox = (Gearbox) o;
        return name.equals(gearbox.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(("Gearbox{"));
        sb.append(super.toString());
        sb.append(", name=").append(getName());
        sb.append("}");
        return sb.toString();
    }
}