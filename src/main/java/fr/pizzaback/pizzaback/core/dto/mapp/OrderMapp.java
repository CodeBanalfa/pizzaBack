package fr.pizzaback.pizzaback.core.dto.mapp;

import fr.pizzaback.pizzaback.core.domain.Order;
import fr.pizzaback.pizzaback.core.dto.OrderDTO;

public class OrderMapp {
	public static OrderDTO orderToDto(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setDate(order.getDate());
        dto.setTotalAmount(order.getTotalAmount());
        return dto;
    }

    public static Order dtoToOrder(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setUserId(dto.getUserId());
        order.setDate(dto.getDate());
        order.setTotalAmount(dto.getTotalAmount());
        return order;
    }

}
