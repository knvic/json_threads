package ru.javatest.Util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Николай on 12.07.2017.
 */

@Component
public class Validation {

    public boolean check_dec(String str){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(str);

        if (m.matches()) {
            System.out.println("Ввод корректен. ОК");
            return true;
        }
        else
        {
            System.out.println("Ошибка! Введена не цифра!!");
        }
        return false;
    }
}
