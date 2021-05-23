package pl.tomaszosuch.bikeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.dto.ItemDto;
import pl.tomaszosuch.bikeshop.exception.ItemNotFoundException;
import pl.tomaszosuch.bikeshop.mapper.ItemMapper;
import pl.tomaszosuch.bikeshop.service.ItemDbServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/v1/item")
public class ItemController {

    private final ItemDbServiceImpl itemDbService;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemDbServiceImpl itemDbService, ItemMapper itemMapper) {
        this.itemDbService = itemDbService;
        this.itemMapper = itemMapper;
    }

    @GetMapping("/getItems")
    public List<ItemDto> getItems() {
        return itemMapper.mapToItemDtoList(itemDbService.getItems());
    }

    @GetMapping("/getItem/{itemId}")
    public ItemDto getItem(@PathVariable Long itemId) {
        return itemMapper.mapToItemDto(itemDbService.getItem(itemId).orElseThrow(() -> new ItemNotFoundException("")));
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemDbService.deleteItem(itemId);
    }

    @PostMapping("/createItem")
    public ItemDto createItem(ItemDto itemDto) {
        itemDbService.saveItem(itemMapper.mapToItem(itemDto));
        return itemDto;
    }

    @PutMapping("/updateItem/{itemId}")
    public ItemDto updateItem(@PathVariable Long itemId, @RequestBody ItemDto itemDto) {
        return itemMapper.mapToItemDto(itemDbService.saveItem(itemMapper.mapToItem(itemDto)));
    }
}
