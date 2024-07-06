package com.example.grafanatest.service.v0;

import com.example.grafanatest.service.OrderService;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV0 implements OrderService {

    private AtomicInteger stock = new AtomicInteger(100);

    @Override
    public void order() {
        log.info("주문-service");
        stock.decrementAndGet();
    }

    @Override
    public void cancel() {
        log.info("취소-service");
        stock.incrementAndGet();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
