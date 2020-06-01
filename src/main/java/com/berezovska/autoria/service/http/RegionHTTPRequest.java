package com.berezovska.autoria.service.http;

import com.berezovska.autoria.model.Region;
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
public class RegionHTTPRequest {
    private static final Logger LOG = LogManager.getLogger(RegionHTTPRequest.class);
    private OkHttpSingleton instance;
    private OkHttpClient client;

    public RegionHTTPRequest() {
        this.instance = OkHttpSingleton.getInstance();
        this.client = instance.getClient();
    }

    public List<Region> getRegions () throws IOException {
        Properties properties = new Url().getProperties();
        String url=String.format("%s%s%s",properties.getProperty("BaseUrl"),"states?api_key=",properties.getProperty("API_KEY"));
        System.out.println(url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response;
        response =client.newCall(request).execute();

        List <Region> regions = mapRegions(response);

        LOG.debug((regions.size()==0)?"No Region found":"Region found");
        return regions;
    }

    private static List<Region> mapRegions (Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(response.body().string(), Region[].class));
    }

}
