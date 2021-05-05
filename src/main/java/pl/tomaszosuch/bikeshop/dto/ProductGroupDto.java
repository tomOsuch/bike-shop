package pl.tomaszosuch.bikeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductGroupDto {

    private final Long id;
    private final String name;
}
