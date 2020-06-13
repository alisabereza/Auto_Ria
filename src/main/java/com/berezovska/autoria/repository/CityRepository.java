package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> getById (int id);

    @Query( value ="SELECT id, name from autoria.public.city where id in (select city_id from autoria.public.region_city l  where l.region_id = :region_id)",
            nativeQuery = true)
    List<City> findByRegion(@Param("region_id") int region_id);
}