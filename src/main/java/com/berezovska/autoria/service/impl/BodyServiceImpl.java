package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.controller.exception.UserAlreadyExistsException;
import com.berezovska.autoria.controller.exception.UserNotExistsException;
import com.berezovska.autoria.model.Body;
import com.berezovska.autoria.repository.BodyRepository;
import com.berezovska.autoria.service.BodyService;
import com.berezovska.autoria.service.http.OkHttpSingleton;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public @Data
class BodyServiceImpl implements BodyService {
    private static final Logger LOG = LogManager.getLogger(BodyServiceImpl.class);
    @Autowired
    private BodyRepository bodyRepository;
    @Autowired
    private OkHttpSingleton instance;

    @Override
    public List<Body> getAll() {
        LOG.debug("get All Bodies: ");
        return bodyRepository.findAll();
    }

    @Override
    public Body getById(int id) {
        LOG.debug("getUser: id=" + id);
        return bodyRepository.findById(id)
                .orElseThrow(() -> new UserNotExistsException(String.format("Body with id = %s not found", id)));
    }

    @Override
    public void save(Body body) {
        if (bodyRepository.findById(body.getId()).isPresent()) {
            throw new UserAlreadyExistsException("This colour already exists");
        }
        bodyRepository.save(body);
    }

    @Override
    public void delete(int id) {
        bodyRepository.deleteById(id);
    }

    @Override
    public Body update(Body body) {
        return bodyRepository.save(body);
    }

    @Override
    public void saveAll(List<Body> bodies) {
        bodyRepository.saveAll(bodies);
    }

}