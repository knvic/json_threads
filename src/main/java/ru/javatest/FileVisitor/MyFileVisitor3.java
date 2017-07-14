package ru.javatest.FileVisitor;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Николай on 13.07.2017.
 *
 * В методе preVisitDirectory() происходит копирование посещаемого каталога и аналогично копируется файл в методе visitFile().
 * Чтобы получить новый путь назначения, используется метод relativize() из класса Path.
 */

public class MyFileVisitor3 extends SimpleFileVisitor<Path> {

    private String pathOfSource;
    private String pathOfDestination;

    public MyFileVisitor3(String pathOfSource, String pathOfDestination) {
        this.pathOfSource = pathOfSource;
        this.pathOfDestination = pathOfDestination;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {

        Path source =Paths.get(pathOfSource);
        Path destination =Paths.get(pathOfDestination);

        Path newd = destination.resolve(source.relativize(path));
        try {
            String ee = path.toString();
            String rr = source.toString();
            if (path.equals(source)) {
                Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Копируем директорию "+ path.getFileName().toString()+" из дирректории "+ path.getParent()+ " в каталог " + newd.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }




    @Override
      public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes){
        Path source =Paths.get(pathOfSource);
        Path destination =Paths.get(pathOfDestination);

        Path newd = destination.resolve(source.relativize(path));
        try {

            String ee = path.getParent().toString();
            String rr = source.toString();
            //if (path.getParent().toString().contains((source.getParent().toString())));
            if (path.getParent().toString().equals((source.toString()))) {
                Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Копируем файл " + path.getFileName().toString() + " из дирректории " + path.getParent() + " в каталог " + newd.getParent());
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
        }
    }

