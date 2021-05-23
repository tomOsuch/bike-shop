package pl.tomaszosuch.bikeshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomaszosuch.bikeshop.domain.Item;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAll();
    Optional<Item> findById(Long id);
    Item save(Item item);
    void deleteById(Long id);
}
