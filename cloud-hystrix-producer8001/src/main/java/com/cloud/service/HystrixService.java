package com.cloud.service;

public interface HystrixService {

    public String ok(int i);
    public String timeout(int i);
    public String cbreak(int i);
}
