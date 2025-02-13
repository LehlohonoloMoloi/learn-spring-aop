package com.zen.learnspringaop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {

    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }

}
