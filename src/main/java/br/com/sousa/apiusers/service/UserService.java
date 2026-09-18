package br.com.sousa.apiusers.service;

import br.com.sousa.apiusers.database.model.UserEntity;
import br.com.sousa.apiusers.database.repository.UserRepository;
import br.com.sousa.apiusers.dto.UserDto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final List<UserEntity> users = new ArrayList<>(UserRepository.getUsers());

    public List<UserEntity> listAll() {
        return users;
    }

    public UserEntity findUserById(Integer id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<UserEntity> findUserByName(String name) {
        List<UserEntity> result = users.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        if(result.isEmpty())
            throw new RuntimeException("Usuário não Encontrado");

        return result;
    }

    public UserEntity createUser(UserDto userDto) {
        Integer newId = users.stream()
                .mapToInt(UserEntity::getId)
                .max()
                .orElse(0) + 1;

        UserEntity newUser = UserEntity.builder()
                .id(newId)
                .name(userDto.getName())
                .sex(userDto.getSex())
                .cpf(userDto.getCpf())
                .email(userDto.getEmail())
                .cel(userDto.getCel())
                .nationality(userDto.getNationality())
                .birthDate(userDto.getBirthDate())
                .build();
        newUser.setAge();
        users.add(newUser);

        return newUser;
    }

    public UserEntity updateUser(UserDto userDto, Integer id) {
        UserEntity newUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não Encontrado"));

        newUser.setName(userDto.getName());
        newUser.setSex(userDto.getSex());
        newUser.setCpf(userDto.getCpf());
        newUser.setEmail(userDto.getEmail());
        newUser.setCel(userDto.getCel());
        newUser.setNationality(userDto.getNationality());
        newUser.setBirthDate(userDto.getBirthDate());
        newUser.setAge();

        return newUser;
    }

    public void deleteUser(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

}
