package br.com.sousa.apiusers.database.repository;

import br.com.sousa.apiusers.database.model.UserEntity;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    @Getter
    private static final List<UserEntity> users = new ArrayList<>();

    static {
        users.add(UserEntity.builder()
                .id(1)
                .name("Felipe")
                .sex("Masculino")
                .cpf("132.102.070-89")
                .email("felipe@gmail.com")
                .cel("(82) 97990-5532")
                .birthDate(LocalDate.of(2003, 4, 21))
                .nationality("Brasileiro")
                .build());

        users.add(UserEntity.builder()
                .id(2)
                .name("Otavio")
                .sex("Masculino")
                .cpf("455.978.414-08")
                .email("otavio@gmail.com")
                .cel("(53) 96819-2383")
                .birthDate(LocalDate.of(2004, 8, 26))
                .nationality("Argentino")
                .build());

        users.add(UserEntity.builder()
                .id(3)
                .name("Gabriella")
                .sex("Feminino")
                .cpf("795.358.080-28")
                .email("gabi@gmail.com")
                .cel("(67) 97325-7642")
                .birthDate(LocalDate.of(2003, 5, 13))
                .nationality("Brasileiro")
                .build());

        users.add(UserEntity.builder()
                .id(4)
                .name("Enzo")
                .sex("Masculino")
                .cpf("642.903.438-05")
                .email("enzo@gmail.com")
                .cel("(92) 99666-4013")
                .birthDate(LocalDate.of(2007, 9, 29))
                .nationality("Brasileiro")
                .build());

        users.add(UserEntity.builder()
                .id(5)
                .name("Kaique")
                .sex("Masculino")
                .cpf("464.512.721-75")
                .email("kaique@gmail.com")
                .cel("(61) 99856-6241")
                .birthDate(LocalDate.of(2002, 1, 30))
                .nationality("Brasileiro")
                .build());

        users.add(UserEntity.builder()
                .id(6)
                .name("Ryan")
                .sex("Masculino")
                .cpf("152.186.033-50")
                .email("ryan@gmail.com")
                .cel("(17) 98611-4636")
                .birthDate(LocalDate.of(2009, 2, 10))
                .nationality("Chinês")
                .build());

        for(UserEntity user : users)
            user.setAge();

    }

}
