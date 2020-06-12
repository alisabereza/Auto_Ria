package com.berezovska.autoria.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table(name = "request")
public @Data
class Request extends BaseEntity {
    @NotEmpty
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;



    @NotEmpty
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "body_id", nullable = false)
    private Body body;

    @NotEmpty
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @NotEmpty
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @Nullable
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Nullable
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Nullable
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "drive_id", nullable = false)
    private Drive drive;

    @Nullable
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "fuel_id", nullable = false)
    private Fuel fuel;

    @Nullable
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "gearbox_id", nullable = false)
    private Gearbox gearbox;

    @Nullable
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "colour_id", nullable = false)
    private Colour colour;
    @Nullable
    @Column(name = "price_min")
    private Double priceMin;
    @Nullable
    @Column(name = "price_max")
    private Double priceMax;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "client_id", nullable = false)
    private User user;

}