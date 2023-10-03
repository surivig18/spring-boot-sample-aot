package com.suria.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@RestController
public class SampleController {


    @GetMapping
    public String  getJavaVersion() throws InterruptedException {
         ExecutorService executorService = Executors.newSingleThreadExecutor();
         var list = new ArrayList();
         for(int i =0 ; i < 100000; i++)
            list.add(new RunnableTask());
        executorService.invokeAll(list);
        return Runtime.version().toString();
    }
}

class RunnableTask implements Callable {

    @Override
    public Object call() throws Exception {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("Key", "Value");
        return  concurrentHashMap;
    }
}
