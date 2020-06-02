package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.Request;
import com.berezovska.autoria.repository.RequestRepository;
import com.berezovska.autoria.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;
    @Override
    public List<Request> getAll() {
        return null;
    }

    @Override
    public Request getById(int id) {
        return null;
    }

    @Override
    public void save(Request entity) {
        requestRepository.save(entity);
    }

    @Override
    public void saveAll(List<Request> entities) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Request update(Request entity) {
        return null;
    }
}
