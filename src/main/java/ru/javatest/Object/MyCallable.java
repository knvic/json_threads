package ru.javatest.Object;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javatest.Util.Rand;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by Николай on 12.07.2017.
 */
public class MyCallable implements Callable<String> {
    @Autowired
    private Rand rrnd;

    private long waitTime;
    private long count;

    public MyCallable(int timeInMillis, int count_value){
        this.waitTime = timeInMillis;
        this.count = count_value;
    }
    @Override
    public String call() throws Exception {
        //Thread.sleep(rrnd.getMinMax(50,1000));

        for (int i=1;i<count+1;i++){
            System.out.println("поток " + Thread.currentThread().getName()+ "  вывод числа "+i);
            Thread.sleep(rrnd.getMinMax(50,1000));
        }

        return Thread.currentThread().getName();
    }
}
