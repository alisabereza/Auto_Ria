package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository ("brandRepository")
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByName (String name);


    @Query( value ="SELECT id, name from autoria.public.brand where id in (select distinct brand_id from autoria.public.category_brand_model l  where l.category_id = :category_id)",
            nativeQuery = true)
     List<Brand> findByCategory(@Param("category_id") int category_id);

}