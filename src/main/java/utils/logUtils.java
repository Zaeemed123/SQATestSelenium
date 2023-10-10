package utils;

import io.qameta.allure.Allure;

public class logUtils {
    public static void log(String message){
        System.out.println(message);
        Allure.addAttachment("Log", message);
    }
}
