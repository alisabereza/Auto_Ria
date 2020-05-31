package com.berezovska.autoria.service.http;

import com.berezovska.autoria.model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public class UpdateCategories {
    private static final Logger LOG = LogManager.getLogger(UpdateCategories.class);
    private OkHttpSingleton instance;
    private OkHttpClient client;

    public UpdateCategories() {
        this.instance = OkHttpSingleton.getInstance();
        this.client = instance.getClient();
    }


//String url = "https://developers.ria.com/auto/categories?api_key=ldmSfiDfxNaPwEUwFEzSuMos8Gk8QHZD8ffMVHCW";


    public List<Category> getCategories () throws IOException {
        Properties properties = new Url().getProperties();
        String url=String.format("%s%s%s",properties.getProperty("BaseUrl"),"categories?api_key=",properties.getProperty("API_KEY"));
        System.out.println(url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response;
        response =client.newCall(request).execute();

        List <Category> categories = mapCategories(response);

        categories.forEach(System.out::println);
        LOG.debug((categories.size()==0)?"No Category found":"Category found");
        return categories;
    }

    private static List<Category> mapCategories (Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(response.body().string(), Category[].class));
    }

}
