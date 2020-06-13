package com.berezovska.autoria.service;

import com.berezovska.autoria.model.City;

import java.util.List;

public interface CityService extends BaseService<City> {
    public List<City> findByRegion(int id);
}

