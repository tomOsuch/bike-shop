package pl.tomaszosuch.bikeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.tomaszosuch.bikeshop.domain.ProductGroup;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductDto {

    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final boolean available;
    private final ProductGroup productGroup;
}
