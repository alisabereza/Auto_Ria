package com.berezovska.autoria.service.http;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;

@Service
public class OkHttpSingleton {
    private static OkHttpSingleton instance;
    private OkHttpClient client;

    private OkHttpSingleton () {
        client = new OkHttpClient();
    }

    public static OkHttpSingleton getInstance () {
        if (instance==null) {
            instance = new OkHttpSingleton();
        }
        return instance;
    }

    public OkHttpClient getClient () {
        return client;
    }

}
