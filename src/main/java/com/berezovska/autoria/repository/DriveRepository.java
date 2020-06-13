package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriveRepository extends JpaRepository<Drive, Integer> {
    Optional<Drive> findByName (String name);
    @Query( value ="SELECT id, name from autoria.public.drive where id in (select drive_id from autoria.public.category_drive l  where l.category_id = :category_id)",
            nativeQuery = true)
    List<Drive> findByCategory(@Param("category_id") int category_id);
}

