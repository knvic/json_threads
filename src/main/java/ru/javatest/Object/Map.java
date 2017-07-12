package ru.javatest.Object;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Николай on 11.07.2017.
 */
@Component
public class Map implements Serializable {
    String count_value;
    String count_threads;

    public Map() {

    }

    public Map(String count_value, String count_threads) {
        this.count_value = count_value;
        this.count_threads = count_threads;
    }

    public String getCount_value() {
        return count_value;
    }

    public void setCount_value(String count_value) {
        this.count_value = count_value;
    }

    public String getCount_threads() {
        return count_threads;
    }

    public void setCount_threads(String count_threads) {
        this.count_threads = count_threads;
    }

    @Override
    public String toString() {
        return "Map{" +
                "count_value='" + count_value + '\'' +
                ", count_threads='" + count_threads + '\'' +
                '}';
    }
}
