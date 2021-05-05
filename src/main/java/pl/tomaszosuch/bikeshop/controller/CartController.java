package pl.tomaszosuch.bikeshop.controller;

import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.domain.Cart;
import pl.tomaszosuch.bikeshop.dto.CartDto;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @GetMapping("/getCarts")
    public List<CartDto> getCarts() {
        return List.of(
            new CartDto(1L)
        );
    }

    @GetMapping("/getCart/{cartId}")
    public CartDto getCart(@PathVariable Long cartId) {
        return new CartDto(1L);
    }

    @DeleteMapping("/deleteCart/{cartId}")
    public void deleteCart(@PathVariable Long cartId) {

    }

    @PostMapping("/createCart")
    public void createCart(Cart cart) {

    }
}
