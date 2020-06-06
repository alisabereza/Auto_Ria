package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository ("modelRepository")
public interface ModelRepository extends JpaRepository<Model, Integer> {
    Optional<Model> getById (int id);

    @Query( value ="SELECT id, name from autoria.public.model where id in (select distinct model_id from autoria.public.category_brand_model l  where l.category_id = :category_id and l.brand_id = :brand_id)",
            nativeQuery = true)
    List<Model> findByCategoryAndBrand(@Param("category_id") int category_id, @Param("brand_id") int brand_id);
}

