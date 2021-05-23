package pl.tomaszosuch.bikeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.domain.User;
import pl.tomaszosuch.bikeshop.dto.UserDto;
import pl.tomaszosuch.bikeshop.exception.UserNotFoundException;
import pl.tomaszosuch.bikeshop.mapper.UserMapper;
import pl.tomaszosuch.bikeshop.service.UserDbServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserDbServiceImpl userDbService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserDbServiceImpl userDbService, UserMapper userMapper) {
        this.userDbService = userDbService;
        this.userMapper = userMapper;
    }

    @GetMapping("/getUsers")
    public List<UserDto> getUsers() {
        List<User> users = userDbService.getAllUser();
        return userMapper.mapToUserDtoList(users);
    }

    @GetMapping("/getUser/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userMapper.mapToUserDto(userDbService.getUser(userId).orElseThrow(() -> new UserNotFoundException("")));
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userDbService.deleteUser(userId);
    }

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto  createUser(@RequestBody UserDto userDto) {
        userDbService.saveUser(userMapper.mapToUser(userDto));
        return userDto;
    }

    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User updateUser = userDbService.saveUser(user);
        return userMapper.mapToUserDto(updateUser);
    }
}
