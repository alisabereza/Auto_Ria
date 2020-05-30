package com.berezovska.autoria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "brand")
public @Data
class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return name.equals(brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(("Brand{"));
        sb.append(super.toString());
        sb.append(", name=").append(getName());
        sb.append("}");
        return sb.toString();
    }
}