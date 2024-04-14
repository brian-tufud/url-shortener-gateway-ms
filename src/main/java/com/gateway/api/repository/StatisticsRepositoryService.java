package com.gateway.api.repository;

import org.springframework.stereotype.Service;

import com.gateway.api.response.LongURLStatisticsResponse;
import com.gateway.api.response.ShortURLStatisticsResponse;

@Service
public class StatisticsRepositoryService {

    public ShortURLStatisticsResponse getShortURLStatistics(String shortURL) {
        return null;
    }

    public LongURLStatisticsResponse getLongURLStatistics(String longURL) {
        return null;
    }
}
