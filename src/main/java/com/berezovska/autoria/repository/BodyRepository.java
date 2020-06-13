package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BodyRepository extends JpaRepository<Body, Integer> {
    Optional<Body> findByName (String name);

    @Query( value ="SELECT id, name from autoria.public.body where id in (select body_id from autoria.public.category_body l  where l.category_id = :category_id)",
            nativeQuery = true)
    List<Body> findByCategory(@Param("category_id") int category_id);
}
