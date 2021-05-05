package pl.tomaszosuch.bikeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDto {

    private final Long id;
    private final int quantity;
}
