package com.berezovska.autoria.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@NoArgsConstructor
@Entity
@Table(name = "body")
public @Data
class Body extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "body", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<CategoryBodyLink> categoryBodyLinks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return name.equals(body.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(("Body{"));
        sb.append(super.toString());
        sb.append(", name=").append(getName());
        sb.append("}");
        return sb.toString();
    }
}