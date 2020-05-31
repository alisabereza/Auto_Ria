package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Body;
import com.berezovska.autoria.model.CategoryBodyLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryBodyLinkRepository extends JpaRepository<CategoryBodyLink, Integer> {
    Optional<Body> findAllById (int BodyId);
}


