package ru.javatest.Object;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Николай on 12.07.2017.
 */
public class MyCallable2 implements Callable<String> {


    private int count_vlue;

   volatile int i;

    public MyCallable2(int count_vlue){

        this.count_vlue =count_vlue;


}


    @Override
    public String call() throws Exception {

        while( i < count_vlue) {

           synchronized() {
               i = i + 1;
           }


            System.out.println("Thread " +  Thread.currentThread().getName() + " is running(" + System.currentTimeMillis() + ") CI = " +i );

                       }
        //System.out.println("Thread " +  Thread.currentThread().getName() + " is finshed with ci = " + ci);


        return Thread.currentThread().getName();
    }


}
