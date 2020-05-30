package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColourRepository extends JpaRepository<Colour, Integer> {
    Optional<Colour> findByName (String name);
}
