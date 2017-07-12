package ru.javatest.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import ru.javatest.Util.Validation;
import ru.javatest.interfaces.Keyboard_enter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Николай on 12.07.2017.
 */
@Component
public class Keyboard_ent_Impl implements Keyboard_enter {
    @Autowired
    Validation valid;

    @Override
    public String enter_from_keyboard(String str) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        System.out.println(str);
        String count_value = reader.readLine();
        while (!valid.check_dec(count_value)){
            System.out.println("Повторитe ввод : ");
            count_value = reader.readLine();
        }
            return count_value;

    }

}
