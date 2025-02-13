package com.zen.learnspringaop.service;

import com.zen.learnspringaop.data.DataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService {

    private DataService dataService;

    public BusinessService(DataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSum() {
        int[] data = dataService.retrieveData();

        return Arrays.stream(data).sum();
    }

    public int simulateException() {
        throw new RuntimeException("Exception thrown from BusinessService1");
    }

}
