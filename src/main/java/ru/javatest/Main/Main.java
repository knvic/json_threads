package ru.javatest.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javatest.Impl.GetJsoImpl;
import ru.javatest.Impl.Keyboard_ent_Impl;
import ru.javatest.Impl.ThreadRunImpl;
import ru.javatest.Object.Map;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


/**
 * Created by Николай on 11.07.2017.
 */

public class Main {


    /*  private static class Incrementer implements Runnable {
          private final AtomicInteger ci;
          private final int locId;

          private Incrementer(AtomicInteger ci, int locId) {
              this.ci = ci;
              this.locId = locId;
          }

          @Override
          public void run() {

            while(ci.get() < 20) {
                  ci.incrementAndGet();
                  System.out.println("Thread " + locId + " is running(" + ci.get() + ") CI = " + ci);
                  *//*try {
                    Thread.sleep((locId < 4 ? locId : 5) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*//*
            }
            System.out.println("Thread " + locId + " is finshed with ci = " + ci);


        }

    }
*/
    public static void main(String[] args) throws Exception {

        //final AtomicInteger ci = new AtomicInteger();
 /*
        AtomicInteger ci = new AtomicInteger();
       System.out.println("ci = " + ci);

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Incrementer(ci, i + 1));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("main ci = " + ci);
*/

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        GetJsoImpl getJso = (GetJsoImpl) context.getBean("getJsoImpl");
        ThreadRunImpl threadRun = (ThreadRunImpl) context.getBean("threadRunImpl");
        Keyboard_ent_Impl keyenter = (Keyboard_ent_Impl) context.getBean("keyboard_ent_Impl");
//Вводим конечное число, выводимое в потоке count_value
        String count_value = keyenter.enter_from_keyboard("Введите число окончания вывода:");
//Вводим число потоков  count_threads
        String count_threads = keyenter.enter_from_keyboard("Введите количество потоков");
//Инициализируем экземпляр класса с данными
        Map map1 = new Map(count_value, count_threads);
//данные класса в формат JSON и записываем в файл
        String filename = getJso.to_json(map1);
//Очищаем класс
        map1 = null;
//Считываем из файла строку JSON и ассоциируем данные на экземпляр класса
        map1 = getJso.from_json(filename);


//Запускаем потоки согласно условию и прочитанным из файла данным формата JSON
        threadRun.thread_run_new(map1.getCount_value(), map1.getCount_threads());


    }

}



        /*  ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        GetJsoImpl getJso= (GetJsoImpl) context.getBean("getJsoImpl");
        ThreadRunImpl threadRun = (ThreadRunImpl)context.getBean("threadRunImpl");
        Keyboard_ent_Impl keyenter = (Keyboard_ent_Impl)context.getBean("keyboard_ent_Impl");
//Вводим конечное число, выводимое в потоке count_value
        String count_value = keyenter.enter_from_keyboard("Введите число окончания вывода:");
//Вводим число потоков  count_threads
        String count_threads = keyenter.enter_from_keyboard("Введите количество потоков");
//Инициализируем экземпляр класса с данными
        Map map1= new Map(count_value,count_threads);
//данные класса в формат JSON и записываем в файл
        String filename =  getJso.to_json(map1);
//Очищаем класс
        map1=null;
//Считываем из файла строку JSON и ассоциируем данные на экземпляр класса
        map1= getJso.from_json(filename);


//Запускаем потоки согласно условию и прочитанным из файла данным формата JSON
        threadRun.thread_run(map1.getCount_value(),map1.getCount_threads());*/

/*

import java.util.concurrent.atomic.AtomicInteger;

    public class Main {

        public static void main(String[] args) throws InterruptedException {
            AtomicInteger ci = new AtomicInteger();
            System.out.println("ci = " + ci);

            Thread[] threads = new Thread[4];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new Incrementer(ci, i + 1));
                threads[i].start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("main ci = " + ci);
        }

        private static class Incrementer implements Runnable {
            private final AtomicInteger ci;
            private final int locId;

            private Incrementer(AtomicInteger ci, int locId) {
                this.ci = ci;
                this.locId = locId;
            }

            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    ci.incrementAndGet();
                    System.out.println("Thread " + locId + " is running(" + i + ")");
                    try {
                        Thread.sleep((locId < 4 ? locId : 5) * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread "+locId+" is finshed with ci = " + ci);

            }
        }
    }
}
*/
