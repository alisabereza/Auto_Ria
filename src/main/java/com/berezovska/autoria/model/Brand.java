package com.berezovska.autoria.model;

import com.berezovska.autoria.model.linking.CategoryBrandModelLink;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "brand")
public @Data
class Brand extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<CategoryBrandModelLink> categoryBrandModelLinks;

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
        final StringBuilder sb = new StringBuilder(("{id:"));
        sb.append(getId());
        sb.append(",name:").append(getName());
          sb.append("}");;

        return sb.toString();
    }
}

