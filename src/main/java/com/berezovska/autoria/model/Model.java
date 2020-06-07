package com.berezovska.autoria.model;

import com.berezovska.autoria.model.linking.CategoryBrandModelLink;
import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "model")
public @Data
class Model extends BaseEntity {
    @Column(name = "name")
    @Expose
    private String name;

    @OneToMany(mappedBy = "model", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<CategoryBrandModelLink> categoryBrandModelLinks;

    public Model (int id, String name) {
        this.setId(id);
        this.name = name;
    }

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