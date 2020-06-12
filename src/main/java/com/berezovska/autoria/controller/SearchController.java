package com.berezovska.autoria.controller;

import com.berezovska.autoria.controller.exception.EntityAlreadyExistsException;
import com.berezovska.autoria.controller.exception.ErrorMessage;
import com.berezovska.autoria.model.Brand;
import com.berezovska.autoria.model.Request;
import com.berezovska.autoria.service.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"search"})
public class SearchController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ModelService modelService;
    @Autowired
    private BodyService bodyService;

    @Autowired
    private RequestService requestService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("categories", categoryService.getAll());
        return "search";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createRequest(@ModelAttribute("requestForm") @Valid Request request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "";
        }
        try {
            System.out.println("Request Category: " + request.getCategory().getName());
            System.out.println("Request Brand: " + request.getBrand().getName());
            System.out.println("Request Model: " + request.getModel().getName());
            request.setBody(bodyService.getById(4));
            requestService.save(request);
            model.addAttribute("model", request.getModel());
            return "";
        } catch (EntityAlreadyExistsException e) {

            model.addAttribute("errors", List.of(new ErrorMessage("", e.getMessage())));
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "loadBrandsByCategory/{category_id}", method = RequestMethod.GET)
    public String loadBrandsByCategory(@PathVariable("category_id") int category_id){
        Gson gson = new Gson();
        List<Brand> brands = brandService.findByCategory(category_id);

        try {
            return gson.toJson(brands);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "loadModelsByCategoryAndBrand/{categoryId}/{brandId}", method = RequestMethod.GET)
    public String loadModelsByCategoryAndBrand(@PathVariable("categoryId") int categoryId, @PathVariable("brandId") int brandId) {
        Gson gson = new Gson();
        return gson.toJson(modelService.findByCategoryAndBrand(categoryId, brandId));
    }

    @ResponseBody
    @RequestMapping(value = "process/{categoryId}/{brandId}/{modelId}", method = RequestMethod.GET)
    public String processRequest(@PathVariable("categoryId") int categoryId, @PathVariable("brandId") int brandId,  @PathVariable("modelId") int modelId) {
        System.out.println("I am in controller: " +categoryService.getById(categoryId).getName() + ", " + brandService.getById(brandId).getName()+  ", " + modelService.getById(brandId).getName());
        Gson gson = new Gson();
        return "Success";
    }

    @ModelAttribute("requestForm")
    public Request getDefaultRequest() {
        return new Request();
    }


}
