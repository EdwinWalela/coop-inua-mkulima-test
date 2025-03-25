package com.edwin.nexus_api.service;

import com.edwin.nexus_api.DTO.OrderDTO;
import com.edwin.nexus_api.DTO.OrderRequestDTO;
import com.edwin.nexus_api.model.Order;
import com.edwin.nexus_api.model.Payment;
import com.edwin.nexus_api.model.Product;
import com.edwin.nexus_api.repository.OrderRepository;
import com.edwin.nexus_api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentRepository paymentRepository;

    public Order createOrder(OrderRequestDTO orderRequest){
        List<Product> products = this.productService.findByIds(orderRequest.getProductIds());

        Float orderTotal = (float) products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        Order newOrder = new Order(
                null,
                orderRequest.getBuyerName(),
                orderTotal,
                false,
                null,
                null
        );

        Order order = this.orderRepository.save(newOrder);

        Payment payment = new Payment(
                null,
                order,
                orderRequest.getAmount(),
                orderRequest.getPaymentMethod(),
                null
        );
        this.paymentRepository.save(payment);
        return order;
    }

    public List<OrderDTO> getorders(Integer page, Integer limit){
        Pageable pageable = PageRequest.of(page,limit);
        List<Order> orders = this.orderRepository.findAll(pageable).getContent();

        List<OrderDTO> orderDTOS = orders.stream().map(order -> {
            Payment payment = this.paymentRepository.findByOrderId(order.getId()).orElseThrow();

            return new OrderDTO(
                    order.getId(),
                    order.getBuyerName(),
                    order.getTotalAmount(),
                    null,
                    payment.getPaymentMethod().name(),
                    payment.getAmount(),
                    order.getCreatedAt()
            );
        }).toList();
        return orderDTOS;
    }

}
