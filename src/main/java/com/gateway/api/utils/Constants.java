package com.gateway.api.utils;

public class Constants {
    
    public static final String SHORT_URL_PREFIX = "https://879e-2800-a4-2296-a500-2471-f02e-eb81-458b.ngrok-free.app/";

    public static final String READ_BASE_URL = "read_base_url";

    public static final String WRITE_BASE_URL = "write_base_url";

    public static final String STATISTICS_BASE_URL = "statistics_base_url";

    public static final String STATISTICS_QUEUE = "statistics_queue";

    public static final String[] IP_HEADER_CANDIDATES = {
        "X-Forwarded-For",
        "Proxy-Client-IP",
        "WL-Proxy-Client-IP",
        "HTTP_X_FORWARDED_FOR",
        "HTTP_X_FORWARDED",
        "HTTP_X_CLUSTER_CLIENT_IP",
        "HTTP_CLIENT_IP",
        "HTTP_FORWARDED_FOR",
        "HTTP_FORWARDED",
        "HTTP_VIA",
        "REMOTE_ADDR"
    };
}
