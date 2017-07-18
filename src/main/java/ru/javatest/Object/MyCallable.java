package ru.javatest.Object;


import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class MyCallable implements Callable<String> {

private int count_vlue;
private AtomicInteger ai;

    public MyCallable(int count_vlue, AtomicInteger ai) {
        this.count_vlue = count_vlue;
        this.ai=ai;
    }

    @Override
    public String call() throws Exception {
        while(ai.intValue() < count_vlue+1) {
            int a=ai.getAndAdd(1);
            System.out.println("Thread " +  Thread.currentThread().getName() + " is running current value = " + a);
        }
    return Thread.currentThread().getName();
    }
}
