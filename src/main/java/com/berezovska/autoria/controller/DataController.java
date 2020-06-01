package com.berezovska.autoria.controller;

import com.berezovska.autoria.model.*;
import com.berezovska.autoria.service.*;
import com.berezovska.autoria.service.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ColourService colourService;
    @Autowired
    private BodyService bodyService;
    @Autowired
    private CategoryBodyLinkService categoryBodyLinkService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private CityService cityService;
    @Autowired
    private RegionCityLinkService regionCityLinkService;


    @GetMapping(path = "/updateData")
    public String updateData() {
        try {
            List<Category> categories = new CategoryHTTPRequest().getCategories();
            categoryService.saveAll(categories);
            List<Colour> colours = new ColourHTTPRequest().getColours();
            colourService.saveAll(colours);
            BodyHTTPRequest bodyHTTPRequest = new BodyHTTPRequest();
            List<Body> bodies;
            CategoryBodyLink categoryBodyLink;
            int k=1;
            for (int i=1; i<=categories.size(); i++)
            {
                bodies = bodyHTTPRequest.getBodies(i);
                bodyService.saveAll(bodies);
                for (int j=0; j<bodies.size(); j++) {
                    categoryBodyLink = new CategoryBodyLink(k,categories.get(i-1), bodies.get(j));
                    categoryBodyLinkService.save(categoryBodyLink);
                    k++;
                }
            }
            List<Region> regions = new RegionHTTPRequest().getRegions();
            System.out.println(regions);
            regionService.saveAll(regions);
            CityHTTPRequest cityHTTPRequest = new CityHTTPRequest();
            List<City> cities;
            RegionCityLink regionCityLink;
            k=1;
            for (int i=1; i<=regions.size(); i++)
            {
                cities = cityHTTPRequest.getCities(i);
                System.out.println(cities);
                cityService.saveAll(cities);
                for (int j=0; j<cities.size(); j++) {
                    regionCityLink = new RegionCityLink(k,regions.get(i-1), cities.get(j));
                    regionCityLinkService.save(regionCityLink);
                    k++;
                }
            }




            return "data_updated";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}