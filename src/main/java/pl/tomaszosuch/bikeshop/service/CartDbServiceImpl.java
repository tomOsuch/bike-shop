package pl.tomaszosuch.bikeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomaszosuch.bikeshop.domain.Cart;
import pl.tomaszosuch.bikeshop.exception.CartNotFoundException;
import pl.tomaszosuch.bikeshop.mapper.CartMapper;
import pl.tomaszosuch.bikeshop.repository.CartRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CartDbServiceImpl implements CartDbService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Autowired
    public CartDbServiceImpl(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> getCart(Long cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long cartId) {
        try {
            cartRepository.deleteById(cartId);
        } catch (CartNotFoundException e) {
            throw new CartNotFoundException("");
        }
    }

    @Override
    public boolean exists(Long id) {
        if (cartRepository.findById(id).isEmpty()) {
            return false;
        }
        return true;
    }
}