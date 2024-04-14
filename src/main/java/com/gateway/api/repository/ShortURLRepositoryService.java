package com.gateway.api.repository;

import java.nio.charset.StandardCharsets;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.gateway.api.request.LongURLRequest;
import com.gateway.api.response.CrudStatusResponse;
import com.gateway.api.utils.Constants;
import com.gateway.api.utils.RestClientService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

@Service
public class ShortURLRepositoryService {

    @Autowired
    private RestClientService restClientService;

    @Autowired
    private Environment env;

    public String getLongURL(String shortURL) throws Exception {
        
        String baseURL = env.getProperty(Constants.READ_BASE_URL);

        HttpGet request = new HttpGet(baseURL + "/url/" + shortURL);

        return restClientService.executeRequest(request, String.class);
    }

    public String shortenURL(LongURLRequest body) throws Exception {
        
        String baseURL = env.getProperty(Constants.WRITE_BASE_URL);

        HttpPost request = new HttpPost(baseURL + "/url");

        String LongURLRequest = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create().toJson(body);

        request.setEntity(new StringEntity(LongURLRequest, StandardCharsets.UTF_8));
        request.addHeader("Content-Type", "application/json");

        return restClientService.executeRequest(request, String.class);
    }

    public CrudStatusResponse deleteURL(String shortURL) throws Exception {
        
        String baseURL = env.getProperty(Constants.WRITE_BASE_URL);

        HttpDelete request = new HttpDelete(baseURL + "/url/" + shortURL);

        return restClientService.executeRequest(request, CrudStatusResponse.class);
    }
}
