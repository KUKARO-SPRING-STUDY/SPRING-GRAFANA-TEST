package com.example.grafanatest.service.v2;

import com.example.grafanatest.service.OrderService;
import io.micrometer.core.annotation.Counted;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV2 implements OrderService {

    private final AtomicInteger stock = new AtomicInteger(100);

    @Override
    @Counted("my.order")
    public void order() {
        log.info("주문-service");
        stock.incrementAndGet();
    }

    @Override
    @Counted("my.order")
    public void cancel() {
        log.info("취소-service");
        stock.decrementAndGet();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
