package com.berezovska.autoria.model.linking;

import com.berezovska.autoria.model.BaseEntity;
import com.berezovska.autoria.model.City;
import com.berezovska.autoria.model.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@Table(name = "region_city")
public @Data
class RegionCityLink extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "city_id")
    private City city;

    public RegionCityLink(int id, Region region, City city) {
        this.setId(id);
        this.region = region;
        this.city = city;
    }
}
