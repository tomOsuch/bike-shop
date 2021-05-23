package pl.tomaszosuch.bikeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomaszosuch.bikeshop.domain.Item;
import pl.tomaszosuch.bikeshop.exception.ItemNotFoundException;
import pl.tomaszosuch.bikeshop.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ItemDbServiceImpl implements ItemDbService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItem(Long itemId) {
        return itemRepository.findById(itemId);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        try {
            itemRepository.deleteById(itemId);
        } catch (ItemNotFoundException e) {
            throw new ItemNotFoundException("");
        }
    }
}
