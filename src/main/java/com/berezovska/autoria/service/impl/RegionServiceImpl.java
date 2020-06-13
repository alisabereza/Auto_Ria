package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.controller.exception.EntityAlreadyExistsException;
import com.berezovska.autoria.model.Region;
import com.berezovska.autoria.repository.RegionRepository;
import com.berezovska.autoria.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;
    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region getById(int id) {
        return null;
    }

    @Override
    public void save(Region entity) {
        if (regionRepository.findById(entity.getId()).isPresent()) {
            throw new EntityAlreadyExistsException("This colour already exists");
        }
        regionRepository.save(entity);
    }

    @Override
    public void saveAll(List<Region> entities) {
regionRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Region update(Region entity) {
        return null;
    }
}
