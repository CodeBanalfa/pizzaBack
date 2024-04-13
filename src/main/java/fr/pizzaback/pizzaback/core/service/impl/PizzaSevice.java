package fr.pizzaback.pizzaback.core.service.impl;
import fr.pizzaback.pizzaback.core.domain.Pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pizzaback.pizzaback.core.repository.IPizzaRepository;
import fr.pizzaback.pizzaback.core.service.IPizzaService;
@Service
public class PizzaSevice implements IPizzaService {
	@Autowired
    private IPizzaRepository pizzaRepository;
	@Override
	public List<Pizza> getAllPizzas() {
		return pizzaRepository.findAll();
		
	}

}
