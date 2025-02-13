package com.zen.learnspringaop.service;

import com.zen.learnspringaop.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    public int calculateSum() {
        int[] data = dataService1.retrieveData();

        return Arrays.stream(data).sum();
    }

}
