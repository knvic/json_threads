package ru.javatest.FileVisitor;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Николай on 13.07.2017.
 *
 *Удаляем указанную директорию вместе с файлами
 */

public class MyFileVisitor4 extends SimpleFileVisitor<Path> {

    private String pathOfSource;

    public MyFileVisitor4(String pathOfSource) {
        this.pathOfSource = pathOfSource;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {


        try {


            Files.deleteIfExists(path);
            System.out.println("Удаляем файл  "+ path.getFileName().toString()+" из дирректории "+ path.getParent());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }


    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
        Path source =Paths.get(pathOfSource);
        if (e == null) {
            Files.deleteIfExists(path);
            System.out.println("Удаляем директорию "+ path.getFileName().toString()+" из дирректории "+ path.getParent());
            return FileVisitResult.CONTINUE;
        }

        else {
            // directory iteration failed
            throw e;
        }
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException exc) throws IOException {
      //  failed.add(path.toString());
        System.out.println("Ошибка доступа к файлу"+ path.getFileName().toString()+" из дирректории "+ path.getParent());
        return FileVisitResult.SKIP_SUBTREE;
    }


}

