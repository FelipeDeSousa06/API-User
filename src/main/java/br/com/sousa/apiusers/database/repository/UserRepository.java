package br.com.sousa.apiusers.database.repository;

import br.com.sousa.apiusers.database.model.UserEntity;

import br.com.sousa.apiusers.utils.AgeUtils;
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
                .cpf("13210207089")
                .email("felipe@gmail.com")
                .cel("82979905532")
                .birthDate(LocalDate.of(2003, 4, 21))
                .nationality("Brasileiro")
                .build());

        users.add(UserEntity.builder()
                .id(2)
                .name("Otavio")
                .sex("Masculino")
                .cpf("45597841408")
                .email("otavio@gmail.com")
                .cel("53968192383")
                .birthDate(LocalDate.of(2004, 8, 26))
                .nationality("Argentino")
                .build());

        users.add(UserEntity.builder()
                .id(3)
                .name("Gabriella")
                .sex("Feminino")
                .cpf("79535808028")
                .email("gabi@gmail.com")
                .cel("67973257642")
                .birthDate(LocalDate.of(2003, 5, 13))
                .nationality("Brasileiro")
                .build());

        users.add(UserEntity.builder()
                .id(4)
                .name("Enzo")
                .sex("Masculino")
                .cpf("64290343805")
                .email("enzo@gmail.com")
                .cel("92996664013")
                .birthDate(LocalDate.of(2007, 9, 29))
                .nationality("Brasileiro")
                .build());

        users.add(UserEntity.builder()
                .id(5)
                .name("Kaique")
                .sex("Masculino")
                .cpf("46451272175")
                .email("kaique@gmail.com")
                .cel("61998566241")
                .birthDate(LocalDate.of(2002, 1, 30))
                .nationality("Brasileiro")
                .build());

        users.add(UserEntity.builder()
                .id(6)
                .name("Ryan")
                .sex("Masculino")
                .cpf("15218603350")
                .email("ryan@gmail.com")
                .cel("17986114636")
                .birthDate(LocalDate.of(2009, 2, 10))
                .nationality("Chinês")
                .build());

        for(UserEntity user : users)
            user.setAge(AgeUtils.calculateAge(user.getBirthDate()));

    }

    public static boolean uniqueByCpf(String cpf, List<UserEntity> listUser) {
        if(cpf == null)
            return false;
        return listUser.stream()
                .anyMatch(user -> cpf.equals(user.getCpf()));
    }

    public static boolean uniqueByCel(String cel, List<UserEntity> listUser) {
        if(cel == null)
            return false;
        return listUser.stream()
                .anyMatch(user -> cel.equals(user.getCel()));
    }

    public static boolean uniqueByEmail(String email, List<UserEntity> listUser) {
        if(email == null)
            return false;
        return listUser.stream()
                .anyMatch(user -> email.equals(user.getEmail()));
    }


}
