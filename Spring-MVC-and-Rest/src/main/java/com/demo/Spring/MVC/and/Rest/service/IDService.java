package com.demo.Spring.MVC.and.Rest.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class IDService {
    private final AtomicLong idGenerator;

    IDService() {
        this.idGenerator = new AtomicLong();
    }

    public long getIdGenerator() {
        return idGenerator.incrementAndGet();
    }
}
