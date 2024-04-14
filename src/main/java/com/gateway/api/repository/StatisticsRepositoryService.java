package com.gateway.api.repository;

import java.net.URI;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.gateway.api.response.LongURLStatisticsResponse;
import com.gateway.api.response.ShortURLStatisticsResponse;
import com.gateway.api.utils.Constants;
import com.gateway.api.utils.RestClientService;

@Service
public class StatisticsRepositoryService {

    @Autowired
    private RestClientService restClientService;

    @Autowired
    private Environment env;

    public ShortURLStatisticsResponse getShortURLStatistics(String shortURL) throws Exception {
        
        String baseURL = env.getProperty(Constants.STATISTICS_BASE_URL);

        HttpGet request = new HttpGet(baseURL + "/statistics/short_url/" + shortURL);

        return restClientService.executeRequest(request, ShortURLStatisticsResponse.class);
    }

    public LongURLStatisticsResponse getLongURLStatistics(String longURL) throws Exception {
        
        String baseURL = env.getProperty(Constants.STATISTICS_BASE_URL);

        HttpGet request = new HttpGet(baseURL + "/statistics/long_url");

        URI uri = new URIBuilder(request.getUri())
                .addParameter("long_url", longURL)
                .build();

        request.setUri(uri);

        return restClientService.executeRequest(request, LongURLStatisticsResponse.class);
    }
}
