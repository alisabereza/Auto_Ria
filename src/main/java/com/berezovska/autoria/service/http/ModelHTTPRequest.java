package com.berezovska.autoria.service.http;

import com.berezovska.autoria.model.Model;
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
public class ModelHTTPRequest {
    private static final Logger LOG = LogManager.getLogger(ModelHTTPRequest.class);
    private OkHttpSingleton instance;
    private OkHttpClient client;

    public ModelHTTPRequest() {
        this.instance = OkHttpSingleton.getInstance();
        this.client = instance.getClient();
    }


    public List<Model> getModels (int categoryNumber, int brandNumber) throws IOException {
        Properties properties = new Url().getProperties();
        String url=String.format("%s%s%s%s%s%s%s",properties.getProperty("BaseUrl"),"categories/",categoryNumber,"/marks/",brandNumber,"/models?api_key=",properties.getProperty("API_KEY"));
        System.out.println(url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response;
        response =client.newCall(request).execute();

        List <Model> Models = mapModels(response);
        LOG.debug((Models.size()==0)?"No Models found":"Models found");
        return Models;
    }

    private static List<Model> mapModels (Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(response.body().string(), Model[].class));
    }

}