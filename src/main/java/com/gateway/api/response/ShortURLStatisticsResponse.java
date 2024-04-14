package com.gateway.api.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ShortURLStatisticsResponse {

    private Long id;
    
    @JsonProperty("short_url")
    private String shortURL;
    
    @JsonProperty("times_used")
    private int timesUsed;
    
    @JsonProperty("long_url")
    private String longURL;
    
    private List<ClientLocationInformationResponse> connections;
}
