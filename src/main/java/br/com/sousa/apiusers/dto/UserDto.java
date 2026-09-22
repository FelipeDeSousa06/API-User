package br.com.sousa.apiusers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {

    @NotBlank(message = "Nome obrigatório")
    private String name;

    private String sex;

    @NotBlank(message = "CPF obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "Email obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Celular obrigatório")
    @Pattern(
            regexp = "^\\d{10,11}$",
            message = "Celular deve conter o DDD e apenas números (ex: 62999999999)"
    )
    private String cel;

    private String nationality;

    @NotNull(message = "Data de nascimento obrigatória")
    @Past(message = "A data de nascimento deve ser uma data no passado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

}
