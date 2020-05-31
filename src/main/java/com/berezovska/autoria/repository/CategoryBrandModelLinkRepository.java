package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Category;
import com.berezovska.autoria.model.CategoryBrandModelLink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryBrandModelLinkRepository extends JpaRepository<CategoryBrandModelLink, Integer> {
    Optional<Category> getById (int id);
}