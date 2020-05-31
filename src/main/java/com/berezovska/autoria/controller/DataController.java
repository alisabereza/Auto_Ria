package com.berezovska.autoria.controller;

import com.berezovska.autoria.model.Category;
import com.berezovska.autoria.model.Colour;
import com.berezovska.autoria.service.CategoryService;
import com.berezovska.autoria.service.ColourService;
import com.berezovska.autoria.service.http.CategoryHTTPRequest;
import com.berezovska.autoria.service.http.ColourHTTPRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

//import com.sap.lmc.beans.OkHttpClientFactory;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ColourService colourService;

    @GetMapping(path = "/updateData")
    public String updateData() {
        try {
            List<Category> categories = new CategoryHTTPRequest().getCategories();
            categoryService.saveAll(categories);
            List<Colour> colours = new ColourHTTPRequest().getColours();
            colourService.saveAll(colours);

            return "data_updated";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }

/*
    @Qualifier("OkHttpClientFactory")
    @Autowired
    private OkHttpClient client;

    private String url = "https://developers.ria.com/auto/categories?api_key=ldmSfiDfxNaPwEUwFEzSuMos8Gk8QHZD8ffMVHCW";

    @GetMapping(path="/data", produces="application/json")
    public String getRecastResponse(Model model) {

        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject json = new JSONObject();
            json.put("conversation",response.body().string());
            System.out.println(json.toString());
            model.addAttribute("json", json);
            return "json";
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
*/


}