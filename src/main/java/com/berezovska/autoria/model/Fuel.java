package com.berezovska.autoria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "fuel")
public @Data
class Fuel extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fuel fuel = (Fuel) o;
        return name.equals(fuel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(("Fuel{"));
        sb.append(super.toString());
        sb.append(", name=").append(getName());
        sb.append("}");
        return sb.toString();
    }
}
