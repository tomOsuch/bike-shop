package pl.tomaszosuch.bikeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.tomaszosuch.bikeshop.domain.Product;

@Getter
@AllArgsConstructor
public class ProductGroupDto {

    private final Long id;
    private final String name;
}
