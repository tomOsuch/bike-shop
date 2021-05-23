package pl.tomaszosuch.bikeshop.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszosuch.bikeshop.domain.User;
import pl.tomaszosuch.bikeshop.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserDbServiceImplTest {

    @InjectMocks
    private UserDbServiceImpl userDbService;

    @Mock
    private UserRepository userRepository;

    private final User user = User.builder()
            .id(1L)
            .firstName("Jan")
            .lastName("Kowalski")
            .email("janKowalski@test.pl")
            .password("test")
            .phoneNumber("111222333")
            .build();

    @Test
    public void testGetAllUser() {
        //Given
        List<User> users = List.of(user);
        when(userRepository.findAll()).thenReturn(users);
        //When
        List<User> resultUsers = userDbService.getAllUser();
        //Then
        assertEquals(1, resultUsers.size());
    }

    @Test
    public void testSaveAndGetUser() {
        //Given
        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findById(user.getId())).thenReturn(Optional.ofNullable(user));
        //When
        User resultSaveUser = userDbService.saveUser(user);
        boolean resultFindById = userDbService.getUser(1L).isPresent();
        //Then
        assertTrue(resultFindById);
        assertEquals(user.getId(), resultSaveUser.getId());
    }

    @Test
    public void testDeleteUser() {
        //Given
        long id = user.getId();
        //When
        userDbService.deleteUser(id);
        //Then
        verify(userRepository, times(1)).deleteById(id);
    }
}
