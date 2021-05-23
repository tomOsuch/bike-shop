package pl.tomaszosuch.bikeshop.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String password;
}
