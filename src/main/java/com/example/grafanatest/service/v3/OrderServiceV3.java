package com.example.grafanatest.service.v3;

import com.example.grafanatest.service.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV3 implements OrderService {
    private final MeterRegistry meterRegistry;

    private final AtomicInteger stock = new AtomicInteger(100);

    public OrderServiceV3(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }


    @Override
    public void order() {
        log.info("주문-service");
        stock.incrementAndGet();
        Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("order3")
                .register(meterRegistry)
                .record(() -> {
                    try {
                        Thread.sleep(new Random().nextInt(350) + 150);
                    } catch (InterruptedException ignored) {
                    }
                });
    }

    @Override
    public void cancel() {
        log.info("취소-service");
        stock.decrementAndGet();
        Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("order2")
                .register(meterRegistry)
                .record(() -> {
                    try {
                        Thread.sleep(new Random().nextInt(100) + 100);
                    } catch (InterruptedException ignored) {
                    }
                });
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
