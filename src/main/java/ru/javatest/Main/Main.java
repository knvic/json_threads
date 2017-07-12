package ru.javatest.Main;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javatest.Impl.GetJsoImpl;
import ru.javatest.Impl.Keyboard_ent_Impl;
import ru.javatest.Impl.ThreadRunImpl;
import ru.javatest.Impl.Work_file_Impl;
import ru.javatest.Object.Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.text.StyleConstants.Size;


/**
 * Created by Николай on 11.07.2017.
 */

public class Main  {


    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        GetJsoImpl getJso= (GetJsoImpl) context.getBean("getJsoImpl");
        //Work_file_Impl work_file= (Work_file_Impl) context.getBean("work_file_Impl");
        ThreadRunImpl threadRun = (ThreadRunImpl)context.getBean("threadRunImpl");
        Keyboard_ent_Impl keyenter = (Keyboard_ent_Impl)context.getBean("keyboard_ent_Impl");

        String count_value = keyenter.enter_from_keyboard("Введите число окончания вывода:");
        String count_threads = keyenter.enter_from_keyboard("Введите количество потоков");

        Map map1= new Map(count_value,count_threads);
        String filename =  getJso.to_json(map1);
        //System.out.println("Строка JSON свормирована "+ json);
        //String filename = work_file.create_file(json)
        //System.out.println("Строка JSON записана в созданный файл "+work_file.create_file(json)+" в виде "+json);
        map1=null;

        map1= getJso.from_json(filename);

        System.out.println(map1.toString());

        threadRun.thread_run(map1.getCount_value(),map1.getCount_threads());
    }


    }
