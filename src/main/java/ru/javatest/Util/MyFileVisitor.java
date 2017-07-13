package ru.javatest.Util;

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
public class MyFileVisitor extends SimpleFileVisitor<Path>
{

    String partOfName;
    String partOfContent;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;
        List<Path> foundFiles = new ArrayList<Path>();
        if(partOfName!=null && !file.getFileName().toString().contains(partOfName))
            containsName = false;

        String content = new String(Files.readAllBytes(file));
        boolean containsContent = true;
        if(partOfContent!=null && !content.contains(partOfContent))
            containsContent = false;

        if(containsName && containsContent)
            foundFiles.add(file);

        return FileVisitResult.CONTINUE;
}
