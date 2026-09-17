package br.com.sousa.apiusers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String nationality;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

}
