package com.berezovska.autoria.service;

import com.berezovska.autoria.model.Body;

import java.util.List;

public interface BodyService extends BaseService<Body> {
    public List<Body> findByCategory(int id);
}

