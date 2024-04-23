package fr.pizzaback.pizzaback.core.dto.mapp;

import fr.pizzaback.pizzaback.core.domain.Pizza;
import fr.pizzaback.pizzaback.core.dto.PizzaDTO;

import java.util.ArrayList;
import java.util.List;

public class PizzaMapp {

    public static List<PizzaDTO> pizzaToDto(List<Pizza> pizzas) {
        List<PizzaDTO> dtos = new ArrayList<>();

        if (pizzas != null) {
            for (Pizza pizza : pizzas) {
                dtos.add(pizzaToDto(pizza));
            }
        }

        return dtos;
    }

    public static PizzaDTO pizzaToDto(Pizza pizza) {
        if (pizza == null) {
            return null; // Vérification des nulls pour éviter des exceptions
        }

        PizzaDTO dto = new PizzaDTO();
        dto.setId(pizza.getId());
        dto.setDescription(pizza.getDescription());
        dto.setName(pizza.getName());
        dto.setImage(pizza.getImage());
        dto.setPrice(pizza.getPrice());
        return dto;
    }

    public static Pizza dtoToPizza(PizzaDTO pizzaDto) {
        if (pizzaDto == null) {
            return null; // Vérification des nulls
        }

        Pizza pizza = new Pizza(); // Correction: retournez un objet Pizza et non pas null
        pizza.setId(pizzaDto.getId());
        pizza.setName(pizzaDto.getName());
        pizza.setDescription(pizzaDto.getDescription());
        pizza.setImage(pizzaDto.getImage());
        pizza.setPrice(pizzaDto.getPrice());
        return pizza;
    }
}
