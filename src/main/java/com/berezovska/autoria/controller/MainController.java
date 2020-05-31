package com.berezovska.autoria.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/"})
public class MainController {
    @Qualifier("OkHttpClientFactory")
    @Autowired
    private OkHttpClient client;

    private String url = "https://developers.ria.com/auto/categories?api_key=ldmSfiDfxNaPwEUwFEzSuMos8Gk8QHZD8ffMVHCW";

    @GetMapping(path = "/")
    public String doGet() {
        return "index";
    }

    @PostMapping(path = "/")
    public String doPost(Model model) {
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject json = new JSONObject();
            json.put("conversation",response.body().string());
            System.out.println(json.toString());
            model.addAttribute("json", json);
            return "index";
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}
