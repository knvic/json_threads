package ru.javatest.Util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by Николай on 13.07.2017.
 */

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    String partOfName="json";
    String partOfContent;

    public MyFileVisitor(String path) {
        this.partOfContent=path;

    }

    public String getPartOfName() {
        return partOfName;
    }

//List<Path> foundFiles = new ArrayList<Path>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;

        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            containsName = false;

        String content = new String(Files.readAllBytes(file));
        boolean containsContent = true;
        if (partOfContent != null && !content.contains(partOfContent))
            containsContent = false;

        if (containsName && containsContent) {
         //   foundFiles.add(file);
            System.out.println("Совпадение найдено в файле "+ file.getFileName().toString()+" дата последнего изменения "+ attrs.creationTime());
        }

        return FileVisitResult.CONTINUE;
    }
}
