package pl.tomaszosuch.bikeshop.controller;

import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.domain.User;
import pl.tomaszosuch.bikeshop.dto.UserDto;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping("/getUsers")
    public List<UserDto> getUsers() {
        return List.of(
                new UserDto(1L, "Jan", "Kowalski", "jan@test.pl", "111222333", "test"),
                new UserDto(2L, "Janina", "Kowalska", "janina@test.pl", "111222333", "test")
        );
    }

    @GetMapping("/getUser/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return new UserDto(1L, "Jan", "Kowalski", "jan@test.pl", "111222333", "test");
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable Long userId) {

    }

    @PostMapping("/createUser")
    public void createUser(User user) {

    }

    @PutMapping("/updateUser/{userId}")
    public UserDto  updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        return new UserDto(1L, "Jan", "Kowalski", "jan@test.pl", "111222333", "test");
    }
}
