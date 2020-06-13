package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Gearbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GearboxRepository extends JpaRepository<Gearbox, Integer> {
    Optional<Gearbox> getById (int id);
    @Query( value ="SELECT id, name from autoria.public.gearbox where id in (select gearbox_id from autoria.public.gearbox l  where l.category_id = :category_id)",
            nativeQuery = true)
    List<Gearbox> findByCategory(@Param("category_id") int category_id);
}

