package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.Fuel;
import com.berezovska.autoria.repository.FuelRepository;
import com.berezovska.autoria.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelServiceImpl implements FuelService {

    @Autowired
    private FuelRepository fuelRepository;
    @Override
    public List<Fuel> getAll() {
        return fuelRepository.findAll();
    }

    @Override
    public Fuel getById(int id) {
        return null;
    }

    @Override
    public void save(Fuel entity) {
fuelRepository.save(entity);
    }

    @Override
    public void saveAll(List<Fuel> entities) {
fuelRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Fuel update(Fuel entity) {
        return null;
    }
}
