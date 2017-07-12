package ru.javatest.Impl;

import org.springframework.stereotype.Component;
import ru.javatest.interfaces.Work_file;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Николай on 12.07.2017.
 */
@Component
public class Work_file_Impl implements Work_file {
    private String line;

@Override
    public  String  create_file(String data) {
        OutputStream os = null;
        String filename = "c:/Java/_log/json.txt";
        try {
            os = new FileOutputStream(new File(filename));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filename;
    }
@Override
    public String read_from_file(String filename) {

        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            System.out.println(line);
           /* while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(line);
        return  line;
    }


}
