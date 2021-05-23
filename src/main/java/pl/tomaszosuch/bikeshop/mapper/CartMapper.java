package pl.tomaszosuch.bikeshop.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tomaszosuch.bikeshop.domain.Cart;
import pl.tomaszosuch.bikeshop.dto.CartDto;
import pl.tomaszosuch.bikeshop.repository.OrderRepository;
import pl.tomaszosuch.bikeshop.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                userRepository.findById(cartDto.getUserId()).orElse(null),
                cartDto.getItems(),
                orderRepository.findById(cartDto.getOrderId()).orElse(null)
        );
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getUser().getId(),
                cart.getItems(),
                cart.getOrder().getId()
        );
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> carts) {
        return carts.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }

    public List<Cart> mapToCartList(final List<CartDto> cartDtoList) {
        return cartDtoList.stream()
                .map(this::mapToCart)
                .collect(Collectors.toList());
    }
}
