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
private AtomicInteger ci;


    public MyCallable1(int count_vlue, AtomicInteger ci) {
        this.count_vlue = count_vlue;
        this.ci=ci;


    }


    @Override
    public String call() throws Exception {

        while(ci.intValue() < count_vlue) {
            //ci.getAndSet(ci.incrementAndGet());
           //ci.addAndGet(1);
            ci.getAndAdd(1);
            //ci.incrementAndGet();
            System.out.println("Thread " +  Thread.currentThread().getName() + " is running(" + System.currentTimeMillis() + ") CI = " + ci);

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
