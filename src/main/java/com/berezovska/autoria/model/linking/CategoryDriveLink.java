package com.berezovska.autoria.model.linking;

import com.berezovska.autoria.model.BaseEntity;
import com.berezovska.autoria.model.Category;
import com.berezovska.autoria.model.Drive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "category_drive")
public @Data
class CategoryDriveLink extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "drive_id")
    private Drive drive;

    public CategoryDriveLink(int id, Category category, Drive drive) {
        this.setId(id);
        this.drive = drive;
        this.category = category;
    }
}
