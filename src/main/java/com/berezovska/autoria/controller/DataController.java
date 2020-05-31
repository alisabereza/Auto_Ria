package com.berezovska.autoria.controller;

import com.berezovska.autoria.model.Body;
import com.berezovska.autoria.model.Category;
import com.berezovska.autoria.model.CategoryBodyLink;
import com.berezovska.autoria.model.Colour;
import com.berezovska.autoria.service.BodyService;
import com.berezovska.autoria.service.CategoryBodyLinkService;
import com.berezovska.autoria.service.CategoryService;
import com.berezovska.autoria.service.ColourService;
import com.berezovska.autoria.service.http.BodyHTTPRequest;
import com.berezovska.autoria.service.http.CategoryHTTPRequest;
import com.berezovska.autoria.service.http.ColourHTTPRequest;
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
                    categoryBodyLink = new CategoryBodyLink(k, categories.get(i-1), bodies.get(j));
                    categoryBodyLinkService.save(categoryBodyLink);
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