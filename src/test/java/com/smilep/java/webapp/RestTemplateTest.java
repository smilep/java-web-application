package com.smilep.java.webapp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class RestTemplateTest {

    @Test
    void shouldPrintErrorForRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.getForEntity("http://hellosmilep.free.beeceptor.com/error/notfound", String.class);
        } catch (Exception e) {
            if(e instanceof HttpClientErrorException) {
                log.error("response body : " + ((HttpClientErrorException) e).getResponseBodyAsString());
            }
            log.error("Error calling REST API", e);
        }
    }
}
