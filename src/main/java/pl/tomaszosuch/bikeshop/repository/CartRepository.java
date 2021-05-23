package pl.tomaszosuch.bikeshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomaszosuch.bikeshop.domain.Cart;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    List<Cart> findAll();
    Optional<Cart> findById(Long id);
    Cart save(Cart cart);
    void deleteById(Long id);
}
