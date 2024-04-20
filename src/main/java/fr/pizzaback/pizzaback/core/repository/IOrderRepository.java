package fr.pizzaback.pizzaback.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.pizzaback.pizzaback.core.domain.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {

}
