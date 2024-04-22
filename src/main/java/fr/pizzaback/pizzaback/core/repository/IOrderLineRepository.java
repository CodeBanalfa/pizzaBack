package fr.pizzaback.pizzaback.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzaback.pizzaback.core.domain.OrderLine;

public interface IOrderLineRepository extends JpaRepository<OrderLine, Long> {
}
