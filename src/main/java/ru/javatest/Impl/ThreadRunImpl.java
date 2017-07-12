package ru.javatest.Impl;

import org.springframework.stereotype.Component;
import ru.javatest.Object.MyCallable;
import ru.javatest.interfaces.ThreadRun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Николай on 12.07.2017.
 */
@Component
public class ThreadRunImpl implements ThreadRun{


    @Override
    public String thread_run(String count_vlue,String count_threads){
        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(count_threads));
        List<Future<String>> list = new ArrayList<Future<String>>();
        MyCallable callable = new MyCallable(0,Integer.parseInt(count_vlue));
        for(int i=1; i<Integer.parseInt(count_threads)+1; i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        for(Future<String> fut : list){
            try {
                  System.out.println(new Date()+ "::" + fut.get()+"работу завершил");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return "asd";
    }







}
