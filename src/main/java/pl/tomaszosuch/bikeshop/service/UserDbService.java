package pl.tomaszosuch.bikeshop.service;

import pl.tomaszosuch.bikeshop.domain.User;
import pl.tomaszosuch.bikeshop.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserDbService {

    List<User> getAllUser();
    Optional<User> getUser(Long id);
    User saveUser(User user);
    User updateUser(UserDto userDto);
    void deleteUser(Long id);
}
