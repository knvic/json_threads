package ru.javatest.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.javatest.Object.Map;
import ru.javatest.interfaces.GetJson;

import java.io.*;

/**
 * Created by Николай on 11.07.2017.
 */
@Component
public class GetJsoImpl implements GetJson {
@Autowired
Work_file_Impl work_file_Impl;

@Override
       public String to_json(Map map) throws JsonProcessingException {
       ObjectMapper mapper = new ObjectMapper();
       String jsonString = mapper.writeValueAsString(map);
        System.out.println("Класс преобразован в строку JSON " + jsonString);
       String filename = work_file_Impl.create_file(jsonString);
       System.out.print("Строка  " + jsonString+ "записана в созданный файл ");
        return filename;
    }

@Override
        public  Map from_json(String filename) {
        String str= work_file_Impl.read_from_file(filename);
        System.out.println("Строка  " + str+ " прочитана из файла "+filename);
        ObjectMapper mapper = new ObjectMapper();
        Map newMap = null;
        try {
            newMap = mapper.readValue(str, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Строка отображена на класс ");
        return newMap;
    }


}
