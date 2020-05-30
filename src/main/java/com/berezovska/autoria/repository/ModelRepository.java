package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    Optional<Model> getById (int id);
}

