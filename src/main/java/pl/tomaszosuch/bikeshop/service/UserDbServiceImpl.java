package pl.tomaszosuch.bikeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomaszosuch.bikeshop.domain.User;
import pl.tomaszosuch.bikeshop.dto.UserDto;
import pl.tomaszosuch.bikeshop.exception.UserNotFoundException;
import pl.tomaszosuch.bikeshop.mapper.UserMapper;
import pl.tomaszosuch.bikeshop.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserDbServiceImpl implements UserDbService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserDbServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserDto userDto) {
        userRepository.findById(userDto.getId()).orElseThrow(() -> new UserNotFoundException(""));
        return userRepository.save(userMapper.mapToUser(userDto));
    }

    @Override
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("");
        }
    }
}
