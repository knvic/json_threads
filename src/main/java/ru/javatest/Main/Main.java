package ru.javatest.Main;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javatest.Impl.GetJsoImpl;
import ru.javatest.Impl.ThreadRunImpl;
import ru.javatest.Impl.Work_file_Impl;
import ru.javatest.Object.Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static javax.swing.text.StyleConstants.Size;


/**
 * Created by Николай on 11.07.2017.
 */

public class Main  {


    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        GetJsoImpl getJso= (GetJsoImpl) context.getBean("getJsoImpl");
        Work_file_Impl work_file= (Work_file_Impl) context.getBean("work_file_Impl");
        ThreadRunImpl threadRun = (ThreadRunImpl)context.getBean("threadRunImpl");

      
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("Введите число окончания вывода:");

        String count_value = reader.readLine();
        System.out.println("Введите число потоков:");
        String count_threads = reader.readLine();

Map map1= new Map(count_value,count_threads);
        String json =  getJso.to_json(map1);
        System.out.println(json);
        System.out.println("файл создан "+work_file.create_file(json));
        map1=null;
        map1= getJso.from_json(json);
        System.out.println(map1.toString());

        threadRun.thread_run(map1.getCount_value(),map1.getCount_threads());
    }


    }
