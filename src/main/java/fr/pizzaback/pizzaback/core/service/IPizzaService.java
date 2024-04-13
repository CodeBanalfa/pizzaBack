/**
 * 
 */
package fr.pizzaback.pizzaback.core.service;

import java.util.List;


import fr.pizzaback.pizzaback.core.domain.Pizza;

/**
 * 
 */
public interface IPizzaService {
	/**
	 *
	 * @return all known pizza
	*/
	List<Pizza> getAllPizzas(); 

}

