package fr.pizzaback.pizzaback.core.dto.mapp;

import java.util.Set;
import java.util.stream.Collectors;

import fr.pizzaback.pizzaback.core.domain.Order;
import fr.pizzaback.pizzaback.core.domain.OrderLine;
import fr.pizzaback.pizzaback.core.domain.Pizza;
import fr.pizzaback.pizzaback.core.dto.OrderDTO;
import fr.pizzaback.pizzaback.core.dto.OrderLineDTO;

public class OrderMapp {

	 public static Order dtoToOrder(OrderDTO dto) {
	        Order order = new Order();
	        order.setId(dto.getId());
	        order.setUserId(dto.getUserId());
	        order.setDate(dto.getDate());
	        order.setTotalAmount(dto.getTotalAmount());

	        Set<OrderLine> orderLines = dto.getOrderLines()
	            .stream()
	            .map(lineDTO -> {
	                OrderLine line = new OrderLine();
	                line.setId(lineDTO.getId());
	                line.setQuantity(lineDTO.getQuantity());
	                Pizza pizza = new Pizza();
	                pizza.setId(lineDTO.getPizzaId());  // Utilisez l'ID pour associer la pizza
	                line.setPizza(pizza);
	                line.setOrder(order);
	                return line;
	            })
	            .collect(Collectors.toSet());

	        order.setOrderLines(orderLines);
	        return order;
	    }

	    public static OrderDTO orderToDto(Order order) {
	        OrderDTO dto = new OrderDTO();
	        dto.setId(order.getId());
	        dto.setUserId(order.getUserId());
	        dto.setDate(order.getDate());
	        dto.setTotalAmount(order.getTotalAmount());

	        Set<OrderLineDTO> orderLineDTOs = order.getOrderLines()
	            .stream()
	            .map(line -> {
	                OrderLineDTO lineDTO = new OrderLineDTO();
	                lineDTO.setId(line.getId());
	                lineDTO.setPizzaId(line.getPizza().getId());
	                lineDTO.setQuantity(line.getQuantity());
	                return lineDTO;
	            })
	            .collect(Collectors.toSet());

	        dto.setOrderLines(orderLineDTOs);
	        return dto;
	    }

}
