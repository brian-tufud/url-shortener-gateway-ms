package com.gateway.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gateway.api.service.ShortURLService;
import com.gateway.api.utils.UtilsService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RedirectController {

    private final ShortURLService shortURLService;
    private final UtilsService utilsService;

    public RedirectController(
        ShortURLService shortURLService,
        UtilsService utilsService) {
            super();
            this.shortURLService = shortURLService;
            this.utilsService = utilsService;
    }

    @GetMapping("/{short_url}") 
    public ResponseEntity<Void> redirect(HttpServletRequest request,
        @PathVariable(value = "short_url") String shortURL) throws Exception {
        
        String longURL = shortURLService.getLongURL(shortURL);

        return null;
    }

}
