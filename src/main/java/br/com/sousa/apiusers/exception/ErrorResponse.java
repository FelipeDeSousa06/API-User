package br.com.sousa.apiusers.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String message;
    private Integer status;
    private List<ValidationError> errors;

    @Getter
    @AllArgsConstructor
    public static class ValidationError {
        private String field;
        private String message;
    }

}
