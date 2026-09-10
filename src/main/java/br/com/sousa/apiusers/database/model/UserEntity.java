package br.com.sousa.apiusers.database.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserEntity {

    private Integer id;
    private String name;
    private String sex;
    private String cpf;
    private String email;
    private String cel;
    private String nationality;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    public Integer getAge() {
        if(this.birthDate == null)
            return null;
        else
            return Period.between(birthDate, LocalDate.now()).getYears();
    }

}
