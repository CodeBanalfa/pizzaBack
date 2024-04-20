package fr.pizzaback.pizzaback.core.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pizzaback.pizzaback.core.domain.Order;
import fr.pizzaback.pizzaback.core.dto.OrderDTO;
import fr.pizzaback.pizzaback.core.dto.mapp.OrderMapp;
import fr.pizzaback.pizzaback.core.repository.IOrderRepository;
import fr.pizzaback.pizzaback.core.service.IOrderService;

@Service
public class OrderService implements IOrderService {

  private IOrderRepository orderRepo;

  @Autowired
  public OrderService(IOrderRepository orderRepo) {
    this.orderRepo = orderRepo;
  }

  public OrderDTO save(OrderDTO orderDTO) {
    Order order = OrderMapp.dtoToOrder(orderDTO); // Utiliser le mapper pour convertir DTO en entité
    order = orderRepo.save(order);
    return OrderMapp.orderToDto(order); // Utiliser le mapper pour convertir l'entité en DTO
  }
}