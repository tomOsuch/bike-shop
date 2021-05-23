package pl.tomaszosuch.bikeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.tomaszosuch.bikeshop.domain.Cart;
import pl.tomaszosuch.bikeshop.domain.Product;

@Getter
@AllArgsConstructor
public class ItemDto {

    private final Long id;
    private final int quantity;
    private final Product product;
    private final Cart cart;
}
