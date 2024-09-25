package br.com.uri.delivery.clients;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class ViaCepClientConfig {

    private int connectTimeout = 5000;
    private int readTimeout = 10000;

    @Bean
    public Request.Options viaCepOptions() {
        return new Request.Options(connectTimeout,
                TimeUnit.MILLISECONDS,
                readTimeout, TimeUnit.MILLISECONDS,
                Boolean.TRUE);
    }
}
