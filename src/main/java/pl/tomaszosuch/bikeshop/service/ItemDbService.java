package pl.tomaszosuch.bikeshop.service;

import pl.tomaszosuch.bikeshop.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemDbService {

    List<Item> getItems();
    Optional<Item> getItem(Long itemId);
    Item saveItem(Item item);
    void deleteItem(Long itemId);
}
