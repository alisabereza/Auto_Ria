package com.berezovska.autoria.service;

import com.berezovska.autoria.model.Brand;

import java.util.List;

public interface BrandService extends BaseService<Brand> {
    public List<Brand> findByCategory(int id);

}
