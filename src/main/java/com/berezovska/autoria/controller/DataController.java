package com.berezovska.autoria.controller;

import com.berezovska.autoria.controller.exception.EntityAlreadyExistsException;
import com.berezovska.autoria.controller.exception.ErrorMessage;
import com.berezovska.autoria.model.*;
import com.berezovska.autoria.model.linking.*;
import com.berezovska.autoria.service.*;
import com.berezovska.autoria.service.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
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
    @Autowired
    private BrandService brandService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private CategoryBrandModelLinkService categoryBrandModelLinkService;
    @Autowired
    private FuelService fuelService;
    @Autowired
    private GearboxService gearboxService;
    @Autowired
    private DriveService driveService;
    @Autowired
    private CategoryDriveLinkService categoryDriveLinkService;
    @Autowired
    private CategoryGearboxLinkService categoryGearboxLinkService;
    @Autowired
    private RequestService requestService;

    @GetMapping(path = "/updateData")
    public String updateData() {
        try {
            List<Category> categories = new CategoryHttpRequest().getCategories();
            categoryService.saveAll(categories);
            List<Colour> colours = new ColourHttpRequest().getColours();
            colourService.saveAll(colours);
            List<Fuel> fuel = new FuelHttpRequest().getFuel();
            fuelService.saveAll(fuel);

            BodyHttpRequest bodyHTTPRequest = new BodyHttpRequest();
            List<Body> bodies;
            CategoryBodyLink categoryBodyLink;
            int k=1;
            for (int i=1; i<=categories.size(); i++)
            {
                bodies = bodyHTTPRequest.getBodies(i);
                bodyService.saveAll(bodies);
                for (Body body : bodies) {
                    categoryBodyLink = new CategoryBodyLink(k, categories.get(i - 1), body);
                    categoryBodyLinkService.save(categoryBodyLink);
                    k++;
                }
            }

            DriveHttpRequest driveHttpRequest = new DriveHttpRequest();
            List<Drive> drives;
            CategoryDriveLink categoryDriveLink;
            k=1;
            for (int i=1; i<=categories.size(); i++)
            {
                drives = driveHttpRequest.getDrives(i);
                driveService.saveAll(drives);
                for (Drive drive : drives) {
                    categoryDriveLink = new CategoryDriveLink(k, categories.get(i - 1), drive);
                    categoryDriveLinkService.save(categoryDriveLink);
                    k++;
                }
            }

            GearboxHttpRequest gearboxHttpRequest = new GearboxHttpRequest();
            List<Gearbox> gearboxes;
            CategoryGearboxLink categoryGearboxLink;
            k=1;
            for (int i=1; i<=categories.size(); i++)
            {
                gearboxes = gearboxHttpRequest.getGearboxes(i);
                gearboxService.saveAll(gearboxes);
                for (Gearbox gearbox : gearboxes) {
                    categoryGearboxLink = new CategoryGearboxLink(k, categories.get(i - 1), gearbox);
                    categoryGearboxLinkService.save(categoryGearboxLink);
                    k++;
                }
            }

            List<Region> regions = new RegionHttpRequest().getRegions();
            regionService.saveAll(regions);
            CityHttpRequest cityHTTPRequest = new CityHttpRequest();
            List<City> cities;
            RegionCityLink regionCityLink;
            k=1;
            for (int i=1; i<=regions.size(); i++)
            {
                cities = cityHTTPRequest.getCities(i);
                cityService.saveAll(cities);
                for (City city : cities) {
                    regionCityLink = new RegionCityLink(k, regions.get(i - 1), city);
                    regionCityLinkService.save(regionCityLink);
                    k++;
                }
            }

/*            BrandHttpRequest brandHTTPRequest = new BrandHttpRequest();
            List<Brand> brands;
            ModelHttpRequest modelHTTPRequest = new ModelHttpRequest();
            List<Model> models;
            CategoryBrandModelLink categoryBrandModelLink;
            k=1;
            int m=1;
            for (int i=1; i<=categories.size(); i++)
            {
                brands = brandHTTPRequest.getBrands(i);
                brandService.saveAll(brands);
                for (int j=1; j<=brands.size(); j++) {
                    models = modelHTTPRequest.getModels(i,j);
                    modelService.saveAll(models);
                    for (int l=1; l<=models.size(); l++) {
                        categoryBrandModelLink = new CategoryBrandModelLink(m, categories.get(i-1), brands.get(j-1), models.get(l-1));
                        categoryBrandModelLinkService.save(categoryBrandModelLink);
                        m++;
                    }
                    k++;
                }
            }*/



            return "data_updated";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @GetMapping(path = "/search")
    public ModelAndView getCreateSearchView(org.springframework.ui.Model model) {
        List<CategoryBrandModelLink> categoryBrandModelLinks = categoryBrandModelLinkService.getAll();
        model.addAttribute("categoryBrandModelList", categoryBrandModelLinks);
        return new ModelAndView("search_request");
    }


    @PostMapping(path = "/search")
    public String createSearchRequest(@ModelAttribute("searchForm") @Valid CategoryBrandModelLink categoryBrandModelLink, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "search_request";
        }
        try {
            categoryBrandModelLinkService.save(categoryBrandModelLink);
            model.addAttribute("id", categoryBrandModelLink.getId());
            return "search_result";
        } catch (EntityAlreadyExistsException e) {

            model.addAttribute("errors", List.of(new ErrorMessage("", e.getMessage())));
            return "search_request";
        }
    }

    @ModelAttribute("searchForm")
    public CategoryBrandModelLink getDefaultCategoryBrandModel() {
        return new CategoryBrandModelLink();
    }
}