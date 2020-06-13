package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.Gearbox;
import com.berezovska.autoria.repository.GearboxRepository;
import com.berezovska.autoria.service.GearboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearboxServiceImpl implements GearboxService {

    @Autowired
    private GearboxRepository gearboxRepository;
    @Override
    public List<Gearbox> getAll() {
        return gearboxRepository.findAll();
    }

    @Override
    public Gearbox getById(int id) {
        return null;
    }

    @Override
    public void save(Gearbox entity) {
        gearboxRepository.save(entity);
    }

    @Override
    public void saveAll(List<Gearbox> entities) {
        gearboxRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Gearbox update(Gearbox entity) {
        return null;
    }

    @Override
    public List<Gearbox> findByCategory(int id) {
        List <Gearbox> drives = gearboxRepository.findByCategory(id);
        return drives;
    }
}
