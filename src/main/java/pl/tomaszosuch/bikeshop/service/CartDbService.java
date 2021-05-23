package pl.tomaszosuch.bikeshop.service;


import pl.tomaszosuch.bikeshop.domain.Cart;

import java.util.List;
import java.util.Optional;

public interface CartDbService {

    List<Cart> getAllCart();
    Optional<Cart> getCart(Long cartId);
    Cart saveCart(Cart cart);
    void deleteCart(Long cartId);
    boolean exists(Long id);
}
