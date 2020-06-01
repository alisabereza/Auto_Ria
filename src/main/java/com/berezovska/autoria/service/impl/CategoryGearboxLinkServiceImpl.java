package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.linking.CategoryGearboxLink;
import com.berezovska.autoria.repository.CategoryGearboxLinkRepository;
import com.berezovska.autoria.service.CategoryGearboxLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryGearboxLinkServiceImpl implements CategoryGearboxLinkService {

    @Autowired
    private CategoryGearboxLinkRepository categoryGearboxLinkRepository;

    @Override
    public List<CategoryGearboxLink> getAll() {
        return null;
    }

    @Override
    public CategoryGearboxLink getById(int id) {
        return null;
    }

    @Override
    public void save(CategoryGearboxLink entity) {
        categoryGearboxLinkRepository.save(entity);
    }

    @Override
    public void saveAll(List<CategoryGearboxLink> entities) {
        categoryGearboxLinkRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public CategoryGearboxLink update(CategoryGearboxLink entity) {
        return null;
    }
}
