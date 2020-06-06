package com.berezovska.autoria.controller;

import com.berezovska.autoria.model.Brand;
import com.berezovska.autoria.service.BrandService;
import com.berezovska.autoria.service.CategoryService;
import com.berezovska.autoria.service.ModelService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = { "search" })
public class SearchController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ModelService modelService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("categories", categoryService.getAll());
        return "search";
    }

    @ResponseBody
    @RequestMapping(value = "loadBrandsByCategory/{category_id}", method = RequestMethod.GET)
    public String loadBrandsByCategory(@PathVariable("category_id") int category_id) {
        Gson gson = new Gson();
       List<Brand> brands = brandService.findByCategory(category_id);
        brands.forEach(System.out::println);

try {
        String stringGson = gson.toJson(brands);
    System.out.println("Brands to Json: " + stringGson);
        return stringGson;}
catch (Exception e) {
    System.out.println(e.getMessage());
    return null;
}
    }

    @ResponseBody
    @RequestMapping(value = "loadModelsByCategoryAndBrand/{categoryId}/{brandId}", method = RequestMethod.GET)
    public String loadModelsByCategoryAndBrand(@PathVariable("categoryId") int categoryId, @PathVariable("brandId") int brandId) {
        Gson gson = new Gson();
        return gson.toJson(modelService.findByCategoryAndBrand(categoryId,brandId));
    }
}
