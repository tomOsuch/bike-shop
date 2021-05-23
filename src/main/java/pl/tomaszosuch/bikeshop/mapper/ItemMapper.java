package pl.tomaszosuch.bikeshop.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tomaszosuch.bikeshop.domain.Item;
import pl.tomaszosuch.bikeshop.dto.ItemDto;
import pl.tomaszosuch.bikeshop.repository.CartRepository;
import pl.tomaszosuch.bikeshop.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ItemMapper(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public Item mapToItem(final ItemDto itemDto) {
        return new Item(
                itemDto.getId(),
                itemDto.getQuantity(),
                productRepository.findById(itemDto.getProduct().getId()).orElse(null),
                cartRepository.findById(itemDto.getCart().getId()).orElse(null)
        );
    }

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getId(),
                item.getQuantity(),
                productRepository.findById(item.getProduct().getId()).orElse(null),
                cartRepository.findById(item.getCart().getId()).orElse(null)
        );
    }

    public List<Item> mapToItemList(final List<ItemDto> itemDtoList) {
        return itemDtoList.stream()
                .map(this::mapToItem)
                .collect(Collectors.toList());
    }

    public List<ItemDto> mapToItemDtoList(final List<Item> items) {
        return items.stream()
                .map(this::mapToItemDto)
                .collect(Collectors.toList());
    }
}
