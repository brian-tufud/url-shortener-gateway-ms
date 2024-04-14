package com.gateway.api.repository;

import org.springframework.stereotype.Service;

import com.gateway.api.request.LongURLRequest;

@Service
public class ShortURLRepositoryService {

    public String getLongURL(String shortURL) {
        return null;
    }

    public String shortenURL(LongURLRequest body) {
        return null;
    }

    public void deleteURL(String shortURL) {
        return;
    }
}
