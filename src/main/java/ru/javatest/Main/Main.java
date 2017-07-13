package ru.javatest.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javatest.Impl.GetJsoImpl;
import ru.javatest.Impl.Keyboard_ent_Impl;
import ru.javatest.Impl.ThreadRunImpl;
import ru.javatest.Object.Map;


/**
 * Created by Николай on 11.07.2017.
 */

public class Main  {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
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

        System.out.println(map1.toString());
//Запускаем потоки согласно условию и прочитанным из файла данным формата JSON
      //  threadRun.thread_run(map1.getCount_value(),map1.getCount_threads());
    }


 }
