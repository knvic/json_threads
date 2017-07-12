package ru.javatest.Util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Николай on 12.07.2017.
 */
@Component
public class Rand {

    private static Random random = new Random();


   public static int getMinMax(int min, int max) {
        int num = min + (int) (random.nextDouble() * (max - min + 1));

        return num;
    }
}
