package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.controller.exception.EntityAlreadyExistsException;
import com.berezovska.autoria.model.City;
import com.berezovska.autoria.repository.CityRepository;
import com.berezovska.autoria.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAll() {
        return null;
    }

    @Override
    public City getById(int id) {
        return null;
    }

    @Override
    public void save(City entity) {
        if (cityRepository.findById(entity.getId()).isPresent()) {
            throw new EntityAlreadyExistsException("This City already exists");
        }
        cityRepository.save(entity);
    }

    @Override
    public void saveAll(List<City> entities) {
cityRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public City update(City entity) {
        return null;
    }
}
