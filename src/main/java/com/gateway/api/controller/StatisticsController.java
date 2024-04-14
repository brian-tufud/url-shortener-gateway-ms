package com.gateway.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gateway.api.response.LongURLStatisticsResponse;
import com.gateway.api.response.ShortURLStatisticsResponse;
import com.gateway.api.service.StatisticsService;
import com.gateway.api.utils.UtilsService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;
    private final UtilsService utilsService;

    public StatisticsController(
        StatisticsService statisticsService,
        UtilsService utilsService) {
            super();
            this.statisticsService = statisticsService;
            this.utilsService = utilsService;
    }

    @GetMapping("/short_url/{short_url}") 
    public ResponseEntity<ShortURLStatisticsResponse> getShortUrlStatistics(HttpServletRequest request,
        @PathVariable(value = "short_url") String shortURL) throws Exception {
        
        ShortURLStatisticsResponse shortURLStatistics = statisticsService.getShortURLStatistics(shortURL);

        HttpHeaders responseHeaders = utilsService.getResponseHeaders();
        return ResponseEntity.ok().headers(responseHeaders).body(shortURLStatistics);
    }

    @GetMapping("/long_url") 
    public ResponseEntity<LongURLStatisticsResponse> getLongURLStatistics(HttpServletRequest request,
        @RequestParam(value = "long_url") String longURL) throws Exception {

        LongURLStatisticsResponse longURLStatistics = statisticsService.getLongURLStatistics(longURL);

        HttpHeaders responseHeaders = utilsService.getResponseHeaders();
        return ResponseEntity.ok().headers(responseHeaders).body(longURLStatistics);
    }

}
