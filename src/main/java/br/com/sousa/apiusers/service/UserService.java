package br.com.sousa.apiusers.service;

import br.com.sousa.apiusers.database.model.UserEntity;
import br.com.sousa.apiusers.database.repository.UserRepository;
import br.com.sousa.apiusers.dto.UserDto;
import br.com.sousa.apiusers.exception.BusinessException;
import br.com.sousa.apiusers.exception.NotFoundException;
import br.com.sousa.apiusers.utils.AgeUtils;
import br.com.sousa.apiusers.utils.SexUtils;

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
        if(existsByCpf(userDto.getCpf()))
            throw new BusinessException("CPF já cadastrado");
        else if(existsByCel(userDto.getCel()))
            throw new BusinessException("Celular já cadastrado");
        else if(existsByEmail(userDto.getEmail()))
            throw new BusinessException("Email já cadastrado");

        Integer newId = users.stream()
                .mapToInt(UserEntity::getId)
                .max()
                .orElse(0) + 1;

        UserEntity newUser = UserEntity.builder()
                .id(newId)
                .name(userDto.getName())
                .cpf(userDto.getCpf())
                .email(userDto.getEmail())
                .cel(userDto.getCel())
                .nationality(userDto.getNationality())
                .birthDate(userDto.getBirthDate())
                .build();

        String formattedSex = SexUtils.formatSex((userDto.getSex()));
        newUser.setSex(formattedSex);

        Integer age = AgeUtils.calculateAge(userDto.getBirthDate());
        newUser.setAge(age);

        users.add(newUser);

        return newUser;
    }

    public UserEntity updateUser(UserDto userDto, Integer id) throws NotFoundException {
        UserEntity newUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Usuário não Encontrado"));

        if(existsByCpf(userDto.getCpf()))
            throw new BusinessException("CPF já cadastrado");
        else if(existsByCel(userDto.getCel()))
            throw new BusinessException("Celular já cadastrado");
        else if(existsByEmail(userDto.getEmail()))
            throw new BusinessException("Email já cadastrado");

        newUser.setName(userDto.getName());

        String formattedSex = SexUtils.formatSex(userDto.getSex());
        newUser.setSex(formattedSex);

        newUser.setCpf(userDto.getCpf());
        newUser.setEmail(userDto.getEmail());
        newUser.setCel(userDto.getCel());
        newUser.setNationality(userDto.getNationality());
        newUser.setBirthDate(userDto.getBirthDate());

        Integer age = AgeUtils.calculateAge(userDto.getBirthDate());
        newUser.setAge(age);

        return newUser;
    }

    public void deleteUser(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    private boolean existsByCpf(String cpf) {
        return UserRepository.uniqueByCpf(cpf, users);
    }

    private boolean existsByCel(String cel) {
        return UserRepository.uniqueByCel(cel, users);
    }

    private boolean existsByEmail(String email) {
        return UserRepository.uniqueByEmail(email, users);
    }

}
