package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.model.Brand;
import com.berezovska.autoria.repository.BrandRepository;
import com.berezovska.autoria.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Qualifier("brandRepository")
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<Brand> getAll() {
        return null;
    }

    @Override
    public Brand getById(int id) {
        return null;
    }

    @Override
    public void save(Brand entity) {
brandRepository.save(entity);
    }

    @Override
    public void saveAll(List<Brand> entities) {
brandRepository.saveAll(entities);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Brand update(Brand entity) {
        return null;
    }

    @Override
    public List<Brand> findByCategory(int id) {
        List <Brand> brands = brandRepository.findByCategory(id);
        System.out.println("Brands: ");
        brands.forEach(System.out::println);
        return brands;
    }

}
