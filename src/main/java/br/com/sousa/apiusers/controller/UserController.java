package br.com.sousa.apiusers.controller;

import br.com.sousa.apiusers.database.model.UserEntity;

import br.com.sousa.apiusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> listUsers() {
        return userService.listAll();
    }

    @GetMapping(value  = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity findUser_id(@PathVariable int id) {
        return userService.findUser_id(id);
    }

}
