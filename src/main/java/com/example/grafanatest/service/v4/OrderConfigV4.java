package com.example.grafanatest.service.v4;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV4 {

    @Bean
    public OrderServiceV4 orderService() {
        return new OrderServiceV4();
    }

    @Bean
    public TimedAspect countedAspect(MeterRegistry meterRegistry) {
        return new TimedAspect(meterRegistry);
    }
}
