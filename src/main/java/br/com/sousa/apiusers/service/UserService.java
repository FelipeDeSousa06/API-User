package br.com.sousa.apiusers.service;

import br.com.sousa.apiusers.database.model.UserEntity;

import br.com.sousa.apiusers.database.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final List<UserEntity> users = new ArrayList<>(UserRepository.getUsers());

    public List<UserEntity> listAll() {
        return users;
    }

    public UserEntity findUser_id(Integer id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

}
