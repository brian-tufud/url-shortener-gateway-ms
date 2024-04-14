package com.gateway.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gateway.api.request.LongURLRequest;
import com.gateway.api.response.CrudStatusResponse;
import com.gateway.api.response.URLResponse;
import com.gateway.api.response.CrudStatusResponse.CrudStatus;
import com.gateway.api.service.ShortURLService;
import com.gateway.api.utils.UtilsService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/short_url")
public class ShortURLController {

    private final ShortURLService shortURLService;
    private final UtilsService utilsService;

    public ShortURLController(
        ShortURLService shortURLService,
        UtilsService utilsService) {
            super();
            this.shortURLService = shortURLService;
            this.utilsService = utilsService;
    }

    @PostMapping()
    public ResponseEntity<URLResponse> shortenURL(HttpServletRequest request,
        @RequestBody LongURLRequest body) throws Exception {

        URLResponse url = shortURLService.shortenURL(body);

        HttpHeaders responseHeaders = utilsService.getResponseHeaders();
        return ResponseEntity.ok().headers(responseHeaders).body(url);
    }

    @DeleteMapping("/{short_url}")
    public ResponseEntity<CrudStatusResponse> deleteURL(HttpServletRequest request,
        @PathVariable(value = "short_url") String shortURL) throws Exception {

        shortURLService.deleteURL(shortURL);

        CrudStatusResponse response = CrudStatusResponse.builder().status(CrudStatus.DELETED).build();

        HttpHeaders responseHeaders = utilsService.getResponseHeaders();
        return ResponseEntity.ok().headers(responseHeaders).body(response);
    }

}
