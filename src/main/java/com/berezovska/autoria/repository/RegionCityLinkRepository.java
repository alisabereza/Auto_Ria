package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Body;
import com.berezovska.autoria.model.RegionCityLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionCityLinkRepository extends JpaRepository<RegionCityLink, Integer> {
    Optional<Body> findAllById (int BodyId);
}