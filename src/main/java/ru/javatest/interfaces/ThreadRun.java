package ru.javatest.interfaces;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Николай on 12.07.2017.
 */
public interface ThreadRun {
    String thread_run(String count_vlue,String count_threads);
    String thread_run_new(String count_vlue, String count_threads);
    String thread_run_new1(String count_vlue, String count_threads);
}
