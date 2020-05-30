package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BodyRepository extends JpaRepository<Body, Integer> {
    Optional<Body> findByName (String name);
}
