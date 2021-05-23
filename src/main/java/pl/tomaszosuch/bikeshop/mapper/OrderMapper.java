package pl.tomaszosuch.bikeshop.mapper;

import org.springframework.stereotype.Service;
import pl.tomaszosuch.bikeshop.domain.Order;
import pl.tomaszosuch.bikeshop.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                order.getOrderDate(),
                order.getComments(),
                order.getTotalValue(),
                order.isCompleted()
        );
    }

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getOrderDate(),
                orderDto.getComments(),
                orderDto.getTotalValue(),
                orderDto.isCompleted()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orders) {
        return orders.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
