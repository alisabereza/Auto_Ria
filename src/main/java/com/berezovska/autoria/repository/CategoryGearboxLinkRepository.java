package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Gearbox;
import com.berezovska.autoria.model.linking.CategoryGearboxLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryGearboxLinkRepository extends JpaRepository<CategoryGearboxLink, Integer> {
    Optional<Gearbox> findAllById (int GearboxId);
}
