package com.gateway.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.api.repository.StatisticsRepositoryService;
import com.gateway.api.response.LongURLStatisticsResponse;
import com.gateway.api.response.ShortURLStatisticsResponse;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepositoryService statisticsRepositoryService;

    public ShortURLStatisticsResponse getShortURLStatistics(String shortURL) {
        return statisticsRepositoryService.getShortURLStatistics(shortURL);
    }

    public LongURLStatisticsResponse getLongURLStatistics(String longURL) {
        return statisticsRepositoryService.getLongURLStatistics(longURL);
    }
}
