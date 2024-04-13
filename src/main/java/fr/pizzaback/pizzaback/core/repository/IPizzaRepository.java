package fr.pizzaback.pizzaback.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.pizzaback.pizzaback.core.domain.Pizza;

@Service
public interface IPizzaRepository extends JpaRepository<Pizza, Short> {

}
