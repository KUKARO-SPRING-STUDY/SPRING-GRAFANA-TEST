package com.example.grafanatest.service.gauge;

import com.example.grafanatest.service.OrderService;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class StockConfigV2 {

    @Bean
    public MeterBinder stockSize(OrderService orderService) {
        return meterRegistry -> {
            Gauge.builder("stock", orderService, service -> {
                        log.info("stock gauge call");
                        return service.getStock().get();
                    })
                    .description("Stock level")
                    .register(meterRegistry);
        };
    }
}
