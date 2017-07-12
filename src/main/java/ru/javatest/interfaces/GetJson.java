package ru.javatest.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.javatest.Object.Map;

/**
 * Created by Николай on 11.07.2017.
 */
public interface GetJson {

    String to_json(Map map) throws JsonProcessingException;
    Map from_json(String filename);

}
