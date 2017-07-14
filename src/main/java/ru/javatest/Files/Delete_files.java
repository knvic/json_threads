package ru.javatest.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Николай on 14.07.2017.
 */
public class Delete_files {
    public static void delete_files (String source) {
        Path pathSource = Paths.get(source);
        try {
            Files.delete(pathSource);
            //d случае если не известно есть ли файл использовать deleteIfExists() чтобы исключить java.nio.file.NoSuchFileException
            System.out.println("File deleted successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
