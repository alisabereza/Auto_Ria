package com.berezovska.autoria.service.http;

import com.berezovska.autoria.model.Drive;
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
public class DriveHttpRequest {
    private static final Logger LOG = LogManager.getLogger(DriveHttpRequest.class);
    private OkHttpSingleton instance;
    private OkHttpClient client;

    public DriveHttpRequest() {
        this.instance = OkHttpSingleton.getInstance();
        this.client = instance.getClient();
    }


    public List<Drive> getDrives (int categoryNumber) throws IOException {
        Properties properties = new Url().getProperties();
        String url=String.format("%s%s%s%s%s",properties.getProperty("BaseUrl"),"categories/",categoryNumber,"/driverTypes?api_key=",properties.getProperty("API_KEY"));
        System.out.println(url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response;
        response =client.newCall(request).execute();

        List <Drive> drives = mapDrives(response);
        LOG.debug((drives.size()==0)?"No Drives found":"Drives found");
        return drives;
    }

    private static List<Drive> mapDrives (Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(response.body().string(), Drive[].class));
    }

}