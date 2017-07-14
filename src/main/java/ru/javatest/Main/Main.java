package ru.javatest.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javatest.FileVisitor.MyFileVisitor3;
import ru.javatest.FileVisitor.MyFileVisitor4;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by Николай on 11.07.2017.
 */

public class Main  {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        //MyFileVisitor1 myFileVisitor = (MyFileVisitor1)context.getBean("myFileVisitor");

        //myFileVisitor.visitFile("c:/Java/_log/",lastModifiedTime());

        Path startPath = Paths.get("c:\\Java\\Test_directory\\");
/*
        MyFileVisitor1 myFileVisitor1 = new MyFileVisitor1("count");
        Files.walkFileTree(startPath, myFileVisitor1);
       System.out.println("Имя файла  " +myFileVisitor1.getPartOfName());


        MyFileVisitor2 myFileVisitor2 = new MyFileVisitor2();
        Files.walkFileTree(startPath, myFileVisitor2);*/


//Копирование
      /*  startPath = Paths.get("c:\\Java\\Test_directory\\");
        MyFileVisitor3 myFileVisitor3 = new MyFileVisitor3("c:\\Java\\Test_directory\\1\\","c:\\Java\\Test_directory\\5\\");
        Files.walkFileTree(startPath, myFileVisitor3);*/
//Удаление!!
        Path startPath4 = Paths.get("c:\\Java\\Test_directory\\5");
        MyFileVisitor4 myFileVisitor4 = new MyFileVisitor4("c:\\Java\\Test_directory\\5\\");
        Files.walkFileTree(startPath4, myFileVisitor4);

        /*GetJsoImpl getJso= (GetJsoImpl) context.getBean("getJsoImpl");
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
        threadRun.thread_run(map1.getCount_value(),map1.getCount_threads());*/
    }


 }
