package com.gateway.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.api.repository.ShortURLRepositoryService;
import com.gateway.api.request.LongURLRequest;
import com.gateway.api.response.URLResponse;
import com.gateway.api.utils.UtilsService;

@Service
public class ShortURLService {

    @Autowired
    private UtilsService utilsService;

    @Autowired
    private ShortURLRepositoryService shortURLRepositoryService;

    public URLResponse getLongURL(String shortURL) throws Exception {
        return shortURLRepositoryService.getLongURL(shortURL);
    }

    public URLResponse shortenURL(LongURLRequest body) throws Exception {
        URLResponse response = shortURLRepositoryService.shortenURL(body);

        return utilsService.getShortURLResponse(response);
    }

    public void deleteURL(String shortURL) throws Exception {
        shortURLRepositoryService.deleteURL(shortURL);
    }

}
