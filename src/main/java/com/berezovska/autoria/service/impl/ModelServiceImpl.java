package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.Model;
import com.berezovska.autoria.repository.ModelRepository;
import com.berezovska.autoria.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;
    @Override
    public List<Model> getAll() {
        return null;
    }

    @Override
    public Model getById(int id) {
        return null;
    }

    @Override
    public void save(Model entity) {
modelRepository.save(entity);
    }

    @Override
    public void saveAll(List<Model> entities) {
modelRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Model update(Model entity) {
        return null;
    }
}
