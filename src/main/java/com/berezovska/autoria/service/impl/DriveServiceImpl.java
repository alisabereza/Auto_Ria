package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.Drive;
import com.berezovska.autoria.repository.DriveRepository;
import com.berezovska.autoria.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveServiceImpl implements DriveService {

    @Autowired
    private DriveRepository driveRepository;
    @Override
    public List<Drive> getAll() {
        return null;
    }

    @Override
    public Drive getById(int id) {
        return null;
    }

    @Override
    public void save(Drive entity) {
driveRepository.save(entity);
    }

    @Override
    public void saveAll(List<Drive> entities) {
driveRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Drive update(Drive entity) {
        return null;
    }
}
