package ru.javatest.Object;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by Николай on 12.07.2017.
 */
public class MyCallable implements Callable<String> {

    private long waitTime;
    private long count;

    public MyCallable(int timeInMillis, int count_value){
        this.waitTime = timeInMillis;
        this.count = count_value;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        // возвращает имя потока, который выполняет этот callable таск
        for (int i=1;i<count+1;i++){
            System.out.println("поток " + Thread.currentThread().getName()+ "вывод числа "+i);
        }

        return Thread.currentThread().getName();
    }
}
