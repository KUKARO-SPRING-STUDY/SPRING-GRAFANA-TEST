package com.example.grafanatest.service.v3;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV3 {

    @Bean
    public OrderServiceV3 orderService(MeterRegistry meterRegistry) {
        return new OrderServiceV3(meterRegistry);
    }
}
