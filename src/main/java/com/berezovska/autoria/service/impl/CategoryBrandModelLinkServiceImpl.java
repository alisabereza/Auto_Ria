package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.CategoryBrandModelLink;
import com.berezovska.autoria.repository.CategoryBrandModelLinkRepository;
import com.berezovska.autoria.service.CategoryBrandModelLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBrandModelLinkServiceImpl implements CategoryBrandModelLinkService {

    @Autowired
    private CategoryBrandModelLinkRepository categoryBrandModelLinkRepository;
    @Override
    public List<CategoryBrandModelLink> getAll() {
        return null;
    }

    @Override
    public CategoryBrandModelLink getById(int id) {
        return null;
    }

    @Override
    public void save(CategoryBrandModelLink entity) {
categoryBrandModelLinkRepository.save(entity);
    }

    @Override
    public void saveAll(List<CategoryBrandModelLink> entities) {
categoryBrandModelLinkRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public CategoryBrandModelLink update(CategoryBrandModelLink entity) {
        return null;
    }
}
