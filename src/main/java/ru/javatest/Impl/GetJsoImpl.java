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


@Override
       public String to_json(Map map) throws JsonProcessingException {
       ObjectMapper mapper = new ObjectMapper();
       String jsonString = mapper.writeValueAsString(map);
      // System.out.println("json " + jsonString);
        return jsonString;
    }

@Override
        public  Map from_json(String str) {
        ObjectMapper mapper = new ObjectMapper();
        Map newMap = null;
        try {
            newMap = mapper.readValue(str, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(newMap.toString());
        return newMap;
    }


}
