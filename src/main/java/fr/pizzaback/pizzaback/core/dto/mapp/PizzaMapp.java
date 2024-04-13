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

    private static PizzaDTO pizzaToDto(Pizza pizza) {
        PizzaDTO dto = new PizzaDTO();

        if (pizza != null) {
            dto.setId(pizza.getId());
            dto.setDescription(pizza.getDescription());
            dto.setName(pizza.getName());
            dto.setImage(pizza.getImage());
            dto.setPrice(pizza.getPrice());
        }

        return dto;
    }
}