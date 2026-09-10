package br.com.sousa.apiusers.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {

    private String name;
    private String sex;
    private String cpf;
    private String email;
    private String cel;
    private LocalDate dateBirth;
    private String nationality;

}
