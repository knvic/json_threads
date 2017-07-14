package ru.javatest.FileVisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Николай on 13.07.2017.
 *
 * При выполнении данного кода будут выведены все вложенные каталоги и файлы по указанному пути.
 */

public class MyFileVisitor2 extends SimpleFileVisitor<Path> {

    String partOfName="json";
    String partOfContent;




    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        System.out.println("Directory name:" + path);
        return FileVisitResult.CONTINUE;
    }




    @Override
      public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes){
        System.out.println("file name:" + path.getFileName()+" директория "+ path.getParent());
        return FileVisitResult.CONTINUE;
        }
    }

