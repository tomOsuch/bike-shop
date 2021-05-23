package pl.tomaszosuch.bikeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import pl.tomaszosuch.bikeshop.domain.Item;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {

    private final Long id;
    private final Long userId;
    private final List<Item> items;
    private final Long orderId;



}
