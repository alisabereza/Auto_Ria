package com.berezovska.autoria.service;

import com.berezovska.autoria.model.Drive;

import java.util.List;

public interface DriveService extends BaseService<Drive> {
    public List<Drive> findByCategory(int id);
}
