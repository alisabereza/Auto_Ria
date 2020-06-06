package com.berezovska.autoria.service;

import com.berezovska.autoria.model.Model;

import java.util.List;

public interface ModelService extends BaseService<Model> {
    public List<Model> findByCategoryAndBrand(int categoryId, int brandId);
}

