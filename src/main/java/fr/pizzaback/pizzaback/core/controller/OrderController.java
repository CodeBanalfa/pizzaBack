package fr.pizzaback.pizzaback.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzaback.pizzaback.core.dto.OrderDTO;
import fr.pizzaback.pizzaback.core.service.IOrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

  
    @PostMapping("/")
    public ResponseEntity<OrderDTO> saveOrder(@Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO save = orderService.save(orderDTO);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
