package com.berezovska.autoria.controller;

import com.berezovska.autoria.controller.exception.ErrorMessage;
import com.berezovska.autoria.model.*;
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
    private DriveService driveService;
    @Autowired
    private FuelService fuelService;
    @Autowired
    private GearboxService gearboxService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ColourService colourService;
    @Autowired
    private UserService userService;

    @Autowired
    private RequestService requestService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("categories", categoryService.getAll());
        modelMap.put("all_fuel", fuelService.getAll());
        modelMap.put("colours", colourService.getAll());
        modelMap.put("regions", regionService.getAll());
        modelMap.put("gearboxes", gearboxService.getAll());
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
            System.out.println("Request Body: " + request.getBody().getName());
            System.out.println("Request Drive: " + request.getDrive().getName());
            System.out.println("Request Fuel: " + request.getFuel().getName());
            System.out.println("Request Gearbox: " + request.getGearbox().getName());
            System.out.println("Request Colour: " + request.getColour().getName());
            System.out.println("Request Region: " + request.getRegion().getName());
            System.out.println("Request City: " + request.getCity().getName());
            //System.out.println("Request User: " + request.getUser().getEmail());

            requestService.save(request);
            model.addAttribute("model", request.getModel());
            return "";
        } catch (Exception e) {

            model.addAttribute("errors", List.of(new ErrorMessage("", e.getMessage())));
            return "";
        }
        catch (Error e) {

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
    @RequestMapping(value = "loadBodiesByCategory/{category_id}", method = RequestMethod.GET)
    public String loadBodiesByCategory(@PathVariable("category_id") int category_id){
        Gson gson = new Gson();
        List<Body> bodies = bodyService.findByCategory(category_id);

        try {
            return gson.toJson(bodies);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @ResponseBody
    @RequestMapping(value = "loadDrivesByCategory/{category_id}", method = RequestMethod.GET)
    public String loadDrivesByCategory(@PathVariable("category_id") int category_id){
        Gson gson = new Gson();
        List<Drive> drives = driveService.findByCategory(category_id);

        try {
            return gson.toJson(drives);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "loadGearboxesByCategory/{category_id}", method = RequestMethod.GET)
    public String loadGeaerboxesByCategory(@PathVariable("category_id") int category_id){
        Gson gson = new Gson();
        List<Gearbox> gearboxes = gearboxService.findByCategory(category_id);

        try {
            return gson.toJson(gearboxes);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "loadCitiesByRegion/{region_id}", method = RequestMethod.GET)
    public String loadCitiesByRegion(@PathVariable("region_id") int region_id){
        Gson gson = new Gson();
        List<City> cities = cityService.findByRegion(region_id);

        try {
            return gson.toJson(cities);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ModelAttribute("requestForm")
    public Request getDefaultRequest() {
        return new Request();
    }


}
