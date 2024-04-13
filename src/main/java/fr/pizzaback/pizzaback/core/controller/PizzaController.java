package fr.pizzaback.pizzaback.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzaback.pizzaback.core.dto.PizzaDTO;
import fr.pizzaback.pizzaback.core.dto.mapp.PizzaMapp;
import fr.pizzaback.pizzaback.core.service.IPizzaService;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {
    @Autowired
    private IPizzaService pizzaService;

    @GetMapping("/")
    public List<PizzaDTO> getAll() {
        return PizzaMapp.pizzaToDto(pizzaService.getAllPizzas());
    }
}
