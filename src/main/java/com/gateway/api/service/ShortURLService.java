package com.gateway.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.api.repository.ShortURLRepositoryService;
import com.gateway.api.request.LongURLRequest;

@Service
public class ShortURLService {

    @Autowired
    private ShortURLRepositoryService shortURLRepositoryService;

    public String getLongURL(String shortURL) throws Exception {
        return shortURLRepositoryService.getLongURL(shortURL);
    }

    public String shortenURL(LongURLRequest body) throws Exception {
        return shortURLRepositoryService.shortenURL(body);
    }

    public void deleteURL(String shortURL) throws Exception {
        shortURLRepositoryService.deleteURL(shortURL);
    }
}
