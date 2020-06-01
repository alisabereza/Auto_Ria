package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.CategoryBodyLink;
import com.berezovska.autoria.repository.CategoryBodyLinkRepository;
import com.berezovska.autoria.service.CategoryBodyLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryBodyLinkServiceImpl implements CategoryBodyLinkService {

    @Autowired
    private CategoryBodyLinkRepository categoryBodyLinkRepository;
    @Override
    public List<CategoryBodyLink> getAll() {
        return null;
    }

    @Override
    public CategoryBodyLink getById(int id) {
        return null;
    }

    @Override
    public void save(CategoryBodyLink categoryBodyLink) {
        categoryBodyLinkRepository.save(categoryBodyLink);
    }

    @Override
    public void saveAll(List<CategoryBodyLink> entities) {
categoryBodyLinkRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public CategoryBodyLink update(CategoryBodyLink entity) {
        return null;
    }
}
