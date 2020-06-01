package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.linking.CategoryDriveLink;
import com.berezovska.autoria.repository.CategoryDriveLinkRepository;
import com.berezovska.autoria.service.CategoryDriveLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDriveLinkServiceImpl implements CategoryDriveLinkService {
    @Autowired
    private CategoryDriveLinkRepository categoryDriveLinkRepository;

    @Override
    public List<CategoryDriveLink> getAll() {
        return null;
    }

    @Override
    public CategoryDriveLink getById(int id) {
        return null;
    }

    @Override
    public void save(CategoryDriveLink entity) {
        categoryDriveLinkRepository.save(entity);
    }

    @Override
    public void saveAll(List<CategoryDriveLink> entities) {
        categoryDriveLinkRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public CategoryDriveLink update(CategoryDriveLink entity) {
        return null;
    }
}
