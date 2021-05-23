package pl.tomaszosuch.bikeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.domain.Order;
import pl.tomaszosuch.bikeshop.dto.OrderDto;
import pl.tomaszosuch.bikeshop.exception.OrderNotFoundException;
import pl.tomaszosuch.bikeshop.mapper.OrderMapper;
import pl.tomaszosuch.bikeshop.service.OrderDbServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderDbServiceImpl orderDbService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderDbServiceImpl orderDbService, OrderMapper orderMapper) {
        this.orderDbService = orderDbService;
        this.orderMapper = orderMapper;
    }

    @GetMapping("/getOrders")
    public List<OrderDto> getOrders() {
        List<Order> orders = orderDbService.getAllOrder();
        return orderMapper.mapToOrderDtoList(orders);
    }

    @GetMapping("/getOrder/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return orderMapper.mapToOrderDto(orderDbService.getOrder(orderId).orElseThrow(() -> new OrderNotFoundException("")));
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderDbService.deleteOrder(orderId);
    }

    @PostMapping(value = "/createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        orderDbService.saveOrder(orderMapper.mapToOrder(orderDto));
        return orderDto;
    }

    @PutMapping("/updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        Order orderUpdate = orderDbService.updateOrder(orderDto);
        return orderMapper.mapToOrderDto(orderUpdate);
    }
}
