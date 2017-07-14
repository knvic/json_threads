package ru.javatest.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Николай on 14.07.2017.
 */
public class Move_files {
    public static void move_files(String source, String destination ) {
        Path pathSource = Paths.get(source);
        Path pathDestination = Paths.get(destination);
        try {
            Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Source file copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
