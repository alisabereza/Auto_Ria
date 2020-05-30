package com.berezovska.autoria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "model")
public @Data
class Model extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return name.equals(model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(("Model{"));
        sb.append(super.toString());
        sb.append(", name=").append(getName());
        sb.append("}");
        return sb.toString();
    }
}