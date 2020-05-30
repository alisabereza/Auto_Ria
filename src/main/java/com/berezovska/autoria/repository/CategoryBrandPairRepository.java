package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Category;
import com.berezovska.autoria.model.CategoryBrandPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryBrandPairRepository extends JpaRepository<CategoryBrandPair, Integer> {
    Optional<Category> getById (int id);
}