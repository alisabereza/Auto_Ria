package com.berezovska.autoria.service.http;

import com.berezovska.autoria.model.Fuel;
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
public class FuelHttpRequest {
    private static final Logger LOG = LogManager.getLogger(FuelHttpRequest.class);
    private OkHttpSingleton instance;
    private OkHttpClient client;

    public FuelHttpRequest() {
        this.instance = OkHttpSingleton.getInstance();
        this.client = instance.getClient();
    }


    public List<Fuel> getFuel () throws IOException {
        Properties properties = new Url().getProperties();
        String url=String.format("%s%s%s",properties.getProperty("BaseUrl"),"type?api_key=",properties.getProperty("API_KEY"));
        System.out.println(url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response;
        response =client.newCall(request).execute();

        List <Fuel> fuel = mapFuel(response);
        LOG.debug((fuel.size()==0)?"No Fuel found":"Fuel found");
        return fuel;
    }

    private static List<Fuel> mapFuel (Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(response.body().string(), Fuel[].class));
    }

}
