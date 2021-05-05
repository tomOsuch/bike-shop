package pl.tomaszosuch.bikeshop.controller;

import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.domain.Item;
import pl.tomaszosuch.bikeshop.dto.ItemDto;

import java.util.List;

@RestController
@RequestMapping("/v1/item")
public class ItemController {

    @GetMapping("/getItems")
    public List<ItemDto> getItems() {
        return List.of(
                new ItemDto(1L, 2)
        );
    }

    @GetMapping("/getItem/{itemId}")
    public ItemDto getItem(@PathVariable Long itemId) {
        return new ItemDto(1L, 2);
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {

    }

    @PostMapping("/createItem")
    public void createItem(Item item) {

    }

    @PutMapping("/updateItem/{itemId}")
    public ItemDto updateItem(@PathVariable Long itemId, @RequestBody ItemDto itemDto) {
        return new ItemDto(1L, 1);
    }
}
