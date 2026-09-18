package br.com.sousa.apiusers.controller;

import br.com.sousa.apiusers.database.model.UserEntity;
import br.com.sousa.apiusers.dto.UserDto;
import br.com.sousa.apiusers.exception.NotFoundException;
import br.com.sousa.apiusers.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> listAllUsers() {
        return userService.listAll();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity findUser_id(@RequestParam Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> findUser_name(@RequestParam String name) {
        return userService.findUserByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create_user(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity update_user(@RequestBody UserDto userDto,
                                  @PathVariable Integer id) throws NotFoundException {
        return userService.updateUser(userDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete_user(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

}
