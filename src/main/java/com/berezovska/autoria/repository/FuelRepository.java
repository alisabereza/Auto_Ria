package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Integer> {
    Optional<Fuel> findByName (String name);
}
