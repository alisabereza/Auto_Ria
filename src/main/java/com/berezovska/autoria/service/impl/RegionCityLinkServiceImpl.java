package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.RegionCityLink;
import com.berezovska.autoria.repository.RegionCityLinkRepository;
import com.berezovska.autoria.service.RegionCityLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionCityLinkServiceImpl implements RegionCityLinkService {

    @Autowired
    private RegionCityLinkRepository regionCityLinkRepository;
    @Override
    public List<RegionCityLink> getAll() {
        return null;
    }

    @Override
    public RegionCityLink getById(int id) {
        return null;
    }

    @Override
    public void save(RegionCityLink entity) {
        regionCityLinkRepository.save(entity);
    }

    @Override
    public void saveAll(List<RegionCityLink> entities) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public RegionCityLink update(RegionCityLink entity) {
        return null;
    }
}
