package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.controller.exception.EntityAlreadyExistsException;
import com.berezovska.autoria.controller.exception.EntityNotExistsException;
import com.berezovska.autoria.model.Colour;
import com.berezovska.autoria.repository.ColourRepository;
import com.berezovska.autoria.service.ColourService;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public @Data
class ColourServiceImpl implements ColourService {
    private static final Logger LOG = LogManager.getLogger(ColourServiceImpl.class);
    @Autowired
    private ColourRepository colourRepository;


    @Override
    public List<Colour> getAll() {
        LOG.debug("get All Colours: ");
        List<Colour> colours = colourRepository.findAll();

        return colours;
    }

    @Override
    public Colour getById(int id) {
        LOG.debug("getColour: id=" + id);
        return colourRepository.findById(id)
                .orElseThrow(() -> new EntityNotExistsException(String.format("Colour with id = %s not found", id)));
    }

    @Override
    public void save(Colour colour) {
        if (colourRepository.findById(colour.getId()).isPresent()) {
            throw new EntityAlreadyExistsException("This colour already exists");
        }
        colourRepository.save(colour);
    }

    @Override
    public void delete(int id) {
        colourRepository.deleteById(id);
    }

    @Override
    public Colour update(Colour colour) {
        return colourRepository.save(colour);
    }

    @Override
    public void saveAll(List<Colour> colours) {
        colourRepository.saveAll(colours);
    }

}