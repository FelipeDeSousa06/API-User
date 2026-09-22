package br.com.sousa.apiusers.utils;

public class SexUtils {

    public static String formatSex(String sex) {
        if("Feminino".equalsIgnoreCase(sex))
            return "Feminino";
        else if("Masculino".equalsIgnoreCase(sex))
            return "Masculino";
        else
            return "Outros";
    }

}
