package pl.tomaszosuch.bikeshop.service;

import pl.tomaszosuch.bikeshop.domain.Order;
import pl.tomaszosuch.bikeshop.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderDbService {

    List<Order> getAllOrder();
    Optional<Order> getOrder(Long id);
    Order saveOrder(Order order);
    Order updateOrder(OrderDto orderDto);
    void deleteOrder(Long id);
}
