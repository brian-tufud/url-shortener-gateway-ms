package com.gateway.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gateway.api.response.URLResponse;
import com.gateway.api.service.DataRecompilationService;
import com.gateway.api.service.ShortURLService;
import com.gateway.api.utils.UtilsService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class RedirectController {

    private final ShortURLService shortURLService;
    private final DataRecompilationService dataRecompilationService;
    private final UtilsService utilsService;

    public RedirectController(
        ShortURLService shortURLService,
        DataRecompilationService dataRecompilationService,
        UtilsService utilsService) {
            super();
            this.shortURLService = shortURLService;
            this.dataRecompilationService = dataRecompilationService;
            this.utilsService = utilsService;
    }

    @GetMapping("/{short_url}") 
    public ResponseEntity<Void> redirect(HttpServletRequest request,
        @PathVariable(value = "short_url") String shortURL) throws Exception {
        
        URLResponse longURL = shortURLService.getLongURL(shortURL);

        dataRecompilationService.sendDataForStatistics(request, shortURL);

        return utilsService.redirect(longURL.getLongURL());
    }

}
