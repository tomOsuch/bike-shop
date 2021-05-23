package pl.tomaszosuch.bikeshop.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszosuch.bikeshop.domain.Order;
import pl.tomaszosuch.bikeshop.dto.OrderDto;
import pl.tomaszosuch.bikeshop.repository.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderDbServiceImplTest {

    @InjectMocks
    private OrderDbServiceImpl orderDbService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void testGetAllOrder() {
        //Given
        List<Order> orders = List.of(new Order(1L, LocalDateTime.now(), "comments_test", new BigDecimal(1000), true));
        when(orderRepository.findAll()).thenReturn(orders);
        //When
        List<Order> resultGetAllOrder = orderDbService.getAllOrder();
        //Then
        assertEquals(1, resultGetAllOrder.size());
    }

    @Test
    public void testGetOrder() {
        //Given
        List<Order> orders = List.of(new Order(1L, LocalDateTime.now(), "comments_test", new BigDecimal(1000), true));
        when(orderRepository.findById(orders.get(0).getId())).thenReturn(Optional.ofNullable(orders.get(0)));
        //When
        boolean resultGetOrderById = orderDbService.getOrder(1L).isPresent();
        //Then
        assertTrue(resultGetOrderById);
    }

    @Test
    public void testSaveOrder() {
        //Given
        Order order = new Order(1L, LocalDateTime.now(), "comments_test", new BigDecimal(1000), true);
        when(orderRepository.save(order)).thenReturn(order);
        //When
        Order resultSaveOrder = orderDbService.saveOrder(order);
        //Then
        assertEquals(order.getId(), resultSaveOrder.getId());
        assertEquals(order.getOrderDate(), resultSaveOrder.getOrderDate());
    }

    @Test
    public void testDeleteOrder() {
        //Given
        Order order = new Order(1L, LocalDateTime.now(), "comments_test", new BigDecimal(1000), true);
        Long id = order.getId();
        //When
        orderDbService.deleteOrder(id);
        //Then
        verify(orderRepository, times(1)).deleteById(id);
    }
}
