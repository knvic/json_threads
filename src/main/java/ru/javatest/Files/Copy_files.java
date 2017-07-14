package ru.javatest.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Николай on 14.07.2017.
 */
public class Copy_files {
    public static void copy(String source, String sdestination) {
        Path pathSource = Paths.get(source);
        Path pathDestination = Paths.get(sdestination);
        try {
            Files.copy(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Source file copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
