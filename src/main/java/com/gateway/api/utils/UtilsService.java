package com.gateway.api.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gateway.api.response.URLResponse;

@Service
public class UtilsService {

    public HttpHeaders getResponseHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        responseHeaders.set("Access-Control-Allow-Headers",
                "Content-Type, X-AUTH-TOKEN ,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization, Accept,Content-Disposition");
        responseHeaders.set("Access-Control-Expose-Headers",
                "content-type,  X-AUTH-TOKEN, X-AUTH-ROLES, Authorization,Content-Disposition");

        return responseHeaders;
    }

        public ResponseEntity<Void> redirect(String url) {
        HttpHeaders responseHeaders = getRedirectHeaders(url);
        return new ResponseEntity<>(responseHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    private HttpHeaders getRedirectHeaders(String url) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromUriString(url).build().toUri());

        return responseHeaders;
    }

    public URLResponse getShortURLResponse(URLResponse shortURL) {
        URLResponse response = new URLResponse();
        
        response.setShortURL(Constants.SHORT_URL_PREFIX + shortURL.getShortURL());

        return response;
    } 

}
