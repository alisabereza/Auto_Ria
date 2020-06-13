package com.berezovska.autoria.service;

import com.berezovska.autoria.model.Gearbox;

import java.util.List;

public interface GearboxService extends BaseService<Gearbox> {
    public List<Gearbox> findByCategory(int id);
}

