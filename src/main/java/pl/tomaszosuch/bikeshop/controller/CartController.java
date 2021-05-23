package pl.tomaszosuch.bikeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.domain.Cart;
import pl.tomaszosuch.bikeshop.dto.CartDto;
import pl.tomaszosuch.bikeshop.exception.CartNotFoundException;
import pl.tomaszosuch.bikeshop.mapper.CartMapper;
import pl.tomaszosuch.bikeshop.service.CartDbServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @Autowired
    private CartDbServiceImpl cartDbService;

    @Autowired
    private CartMapper cartMapper;

    @GetMapping("/getCarts")
    public List<CartDto> getCarts() {
        return cartMapper.mapToCartDtoList(cartDbService.getAllCart());
    }

    @GetMapping("/getCart/{cartId}")
    public CartDto getCart(@PathVariable Long cartId) {
        return cartMapper.mapToCartDto(cartDbService.getCart(cartId).orElseThrow(() -> new CartNotFoundException("")));
    }

    @DeleteMapping("/deleteCart/{cartId}")
    public void deleteCart(@PathVariable Long cartId) {
        cartDbService.deleteCart(cartId);
    }

    @PostMapping("/createCart")
    public CartDto createCart(CartDto cartDto) {
        cartDbService.saveCart(cartMapper.mapToCart(cartDto));
        return cartDto;
    }

    @PutMapping(value = "/updateCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return cartMapper.mapToCartDto(cartMapper.mapToCart(cartDto));
    }
}
