package com.berezovska.autoria.service.impl;


import com.berezovska.autoria.controller.exception.EntityAlreadyExistsException;
import com.berezovska.autoria.controller.exception.EntityNotExistsException;
import com.berezovska.autoria.model.Category;
import com.berezovska.autoria.repository.CategoryRepository;
import com.berezovska.autoria.service.CategoryService;
import com.berezovska.autoria.service.http.OkHttpSingleton;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public @Data class CategoryServiceImpl implements CategoryService {
        private static final Logger LOG = LogManager.getLogger(com.berezovska.autoria.service.impl.UserServiceImpl.class);
        @Autowired
        private CategoryRepository categoryRepository;
        @Autowired
        private OkHttpSingleton instance;

        @Override
        public List<Category> getAll() {
            LOG.debug("get All Categories: ");
            return categoryRepository.findAll();
        }

        @Override
        public Category getById(int id) {
            LOG.debug("getUser: id=" + id);
            return categoryRepository.findById(id)
                    .orElseThrow(() -> new EntityNotExistsException(String.format("User with id = %s not found", id)));
        }

        @Override
        public void save(Category category) {
            if (categoryRepository.findById(category.getId()).isPresent()) {
                throw new EntityAlreadyExistsException("This category already exists");
            }
        categoryRepository.save(category);
        }

        @Override
        public void delete(int id) {
            categoryRepository.deleteById(id);
        }

        @Override
        public Category update(Category entity) {
            return categoryRepository.save(entity);
        }

        @Override
        public void saveAll(List<Category> categories) {
            categoryRepository.saveAll(categories);
        }

    }
