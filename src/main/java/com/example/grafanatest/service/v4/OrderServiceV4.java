package com.example.grafanatest.service.v4;

import com.example.grafanatest.service.OrderService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV4 implements OrderService {

    private final AtomicInteger stock = new AtomicInteger(100);


    @Override
    @Timed(value = "my.order", description = "order4")
    public void order() {
        log.info("주문-service");
        stock.incrementAndGet();
    }

    @Override
    @Timed(value = "my.order", description = "order4")
    public void cancel() {
        log.info("취소-service");
        stock.decrementAndGet();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
