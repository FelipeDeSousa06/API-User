package br.com.sousa.apiusers.utils;

import java.time.LocalDate;
import java.time.Period;

public class AgeUtils {

    public static Integer calculateAge(LocalDate birthDate) {
        if(birthDate != null)
            return Period.between(birthDate, LocalDate.now()).getYears();
        else
            return null;
    }

}
