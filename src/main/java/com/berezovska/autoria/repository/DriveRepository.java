package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriveRepository extends JpaRepository<Drive, Integer> {
    Optional<Drive> findByName (String name);
}

