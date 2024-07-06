package com.example.grafanatest;

import com.example.grafanatest.service.gauge.StockConfigV2;
import com.example.grafanatest.service.v4.OrderConfigV4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({OrderConfigV4.class, StockConfigV2.class})
@SpringBootApplication(scanBasePackages = "com.example.grafanatest.controller")
public class GrafanaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrafanaTestApplication.class, args);
    }

}
