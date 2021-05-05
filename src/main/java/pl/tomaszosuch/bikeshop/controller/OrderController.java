package pl.tomaszosuch.bikeshop.controller;

import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.domain.Order;
import pl.tomaszosuch.bikeshop.dto.OrderDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping("/getOrders")
    public List<Order> getOrders() {
        return List.of(
                new Order(1L, LocalDateTime.now(), "test_comments", new BigDecimal(100), false),
                new Order(2L, LocalDateTime.now(), "test_comments", new BigDecimal(100), true)
        );
    }

    @GetMapping("/getOrder/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return new OrderDto(1L, LocalDateTime.now(), "test_comments", new BigDecimal(100), false);
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {

    }

    @PostMapping("/createOrder")
    public void createOrder(Order order) {

    }

    @PutMapping("/updateOrder/{orderId}")
    public OrderDto updateOrder(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
        return new OrderDto(1L, LocalDateTime.now(), "test_comments", new BigDecimal(100), false);
    }
}
