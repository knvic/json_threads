package ru.javatest.Main;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Николай on 18.07.2017.
 */
public class M1 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger ci = new AtomicInteger();
        System.out.println("ci = " + ci);

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Incrementer(ci, i + 1));
            threads[i].start();
        }
       /* for (Thread thread : threads) {
            thread.join();
        }*/
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
//            for (int i = 0; i <20; i++) {
                //
              while (ci.intValue()<1000){
               // ci.getAndAdd(1);
                  System.out.println("Thread " + locId + " is running(" + ci.getAndAdd(1) + ")");

               // System.out.println("Thread " + locId + " is running(" + ci.intValue() + ")");
                /*try {
                    Thread.sleep((locId < 4 ? locId : 5) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            System.out.println("Thread "+locId+" is finshed with ci = " + ci);

        }
    }
}


