package pl.tomaszosuch.bikeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomaszosuch.bikeshop.domain.Order;
import pl.tomaszosuch.bikeshop.dto.OrderDto;
import pl.tomaszosuch.bikeshop.exception.OrderNotFoundException;
import pl.tomaszosuch.bikeshop.mapper.OrderMapper;
import pl.tomaszosuch.bikeshop.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class OrderDbServiceImpl implements OrderDbService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderDbServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(OrderDto orderDto) {
        orderRepository.findById(orderDto.getId()).orElseThrow(() -> new OrderNotFoundException(""));
        return orderRepository.save(orderMapper.mapToOrder(orderDto));
    }

    @Override
    public void deleteOrder(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (OrderNotFoundException e) {
            throw new OrderNotFoundException("");
        }
    }
}
