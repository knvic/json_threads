package ru.javatest.Object;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javatest.Impl.ThreadRunImpl;
import ru.javatest.Util.Rand;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Николай on 12.07.2017.
 */
public class MyCallable1 implements Callable<String> {


private int count_vlue;
volatile AtomicInteger ci;


    public MyCallable1(int count_vlue, AtomicInteger ci) {
        this.count_vlue = count_vlue;
        this.ci=ci;

    }


    @Override
    public String call() throws Exception {

        while(ci.intValue() < count_vlue+1) {
            //ci.getAndSet(ci.incrementAndGet());
           //ci.addAndGet(1);
         //   System.out.println("Thread " +  Thread.currentThread().getName() + " is running(" + System.currentTimeMillis() + ") CI = " + ci);
            int a=ci.getAndAdd(1);
            System.out.println("Thread " +  Thread.currentThread().getName() + " is running(" + System.currentTimeMillis() + ") CI = " + a);
            //ci.incrementAndGet();


                /*try {
                    Thread.sleep((locId < 4 ? locId : 5) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
        }
        //System.out.println("Thread " +  Thread.currentThread().getName() + " is finshed with ci = " + ci);


        return Thread.currentThread().getName();
    }
}
