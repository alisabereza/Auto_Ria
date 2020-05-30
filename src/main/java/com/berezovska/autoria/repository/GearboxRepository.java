package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Gearbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GearboxRepository extends JpaRepository<Gearbox, Integer> {
    Optional<Gearbox> getById (int id);
}

