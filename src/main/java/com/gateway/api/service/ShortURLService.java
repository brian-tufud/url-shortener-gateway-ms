package com.gateway.api.service;

import com.gateway.api.repository.ShortURLRepositoryService;
import com.gateway.api.request.LongURLRequest;
import com.gateway.api.response.URLResponse;
import com.gateway.api.utils.UtilsService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class ShortURLService {

    @Autowired
    private UtilsService utilsService;

    @Autowired
    private ShortURLRepositoryService shortURLRepositoryService;

    private final LoadingCache<String, URLResponse> longURLCache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(new CacheLoader<String, URLResponse>() {
                @Override
                public URLResponse load(String shortURL) throws Exception {
                    return shortURLRepositoryService.getLongURL(shortURL);
                }
            });

    public URLResponse getLongURL(String shortURL) throws Exception {
        try {
            return longURLCache.get(shortURL);
        } catch (ExecutionException e) {
            throw new Exception("Error al obtener la URL larga", e.getCause());
        }
    }

    public URLResponse shortenURL(LongURLRequest body) throws Exception {
        URLResponse response = shortURLRepositoryService.shortenURL(body);
        return utilsService.getShortURLResponse(response);
    }

    public void deleteURL(String shortURL) throws Exception {
        shortURLRepositoryService.deleteURL(shortURL);

        longURLCache.invalidate(shortURL);
    }
}
