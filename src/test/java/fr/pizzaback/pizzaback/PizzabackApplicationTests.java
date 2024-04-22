package fr.pizzaback.pizzaback;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fr.pizzaback.pizzaback.security.models.User;
import fr.pizzaback.pizzaback.core.domain.Order;
import fr.pizzaback.pizzaback.core.domain.OrderLine;
import fr.pizzaback.pizzaback.core.domain.Pizza;
import fr.pizzaback.pizzaback.core.dto.OrderDTO;
import fr.pizzaback.pizzaback.core.dto.OrderLineDTO;
import fr.pizzaback.pizzaback.core.dto.PizzaDTO;
import fr.pizzaback.pizzaback.core.dto.mapp.OrderMapp;
import fr.pizzaback.pizzaback.core.dto.mapp.PizzaMapp;
import fr.pizzaback.pizzaback.security.Dto.UserDto;
import fr.pizzaback.pizzaback.security.models.Role;
import fr.pizzaback.pizzaback.security.models.RoleName;



@SpringBootTest
class PizzabackApplicationTests {

	@Test
    void testUserDtoCreation() {
        // Préparation des données de test
        User user = new User();
        user.setUsername("testuser");
        user.setFirstname("John");
        user.setLastname("Doe");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName(RoleName.USER); 
        roles.add(role);

        user.setRoles(roles);

        // Appel de la méthode à tester
        UserDto userDto = new UserDto(user);

     
        assertThat("testuser", userDto.getUsername());
        assertThat("John", userDto.getFirstname());
        assertThat("Doe", userDto.getLastname());
        assertThat("USER", userDto.getRole()); // Vérifier que le rôle est correctement défini
    }

	private void assertThat(String string, String username) {
		// TODO Auto-generated method stub
		
	}
	 @Test
	    void testDtoToOrder() {
	        // Créer une instance d'OrderDTO avec des lignes
	        OrderDTO orderDto = new OrderDTO();
	        orderDto.setId(1L);
	        orderDto.setUserId(10L);
	        orderDto.setDate(new java.util.Date());
	        orderDto.setTotalAmount(new BigDecimal("50.00"));

	        Set<OrderLineDTO> orderLineDtos = new HashSet<>();
	        OrderLineDTO lineDto = new OrderLineDTO();
	        lineDto.setId(1L);
	        lineDto.setPizzaId((short) 1);
	        lineDto.setQuantity(2);

	        orderLineDtos.add(lineDto);

	        orderDto.setOrderLines(orderLineDtos);

	        // Convertir en Order en utilisant OrderMapper (nouvelle classe)
	        Order order = OrderMapp.dtoToOrder(orderDto); // Remplacement par OrderMapper

	        // Vérifier que les données sont correctement transférées
	        assertEquals(1L, order.getId(), "L'ID doit correspondre");
	        assertEquals(10L, order.getUserId(), "L'ID utilisateur doit correspondre");
	        assertNotNull(order.getDate(), "La date doit être définie");
	        assertEquals(new BigDecimal("50.00"), order.getTotalAmount(), "Le montant total doit correspondre");

	        // Vérifier les lignes de commande
	        OrderLine line = order.getOrderLines().iterator().next();
	        assertEquals(1L, line.getId(), "L'ID de ligne doit correspondre");
	        assertEquals((short) 1, line.getPizza().getId(), "L'ID de la pizza doit correspondre");
	        assertEquals(2, line.getQuantity(), "La quantité doit correspondre");
	    }

	private void assertEquals(BigDecimal bigDecimal, BigDecimal totalAmount, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(String date, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, int quantity, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(short l, Short id, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(long l, Long id, String string) {
		// TODO Auto-generated method stub
		
	}
	 @Test
	    void testPizzaToDto() {
	        Pizza pizza = new Pizza();
	        pizza.setId((short) 1);
	        pizza.setName("Margherita");
	        pizza.setDescription("Tomato, Mozzarella, Basil");
	        pizza.setImage("margherita.jpg");
	        pizza.setPrice(new BigDecimal("10.00"));

	        PizzaDTO pizzaDto = PizzaMapp.pizzaToDto(pizza);

	        // Vérifier que les données sont correctement transférées
	        assertThat(Short.valueOf((short) 1), pizzaDto.getId(), "L'ID doit correspondre");
	        assertThat("Margherita", pizzaDto.getName(), "Le nom doit correspondre");
	        assertThat("Tomato, Mozzarella, Basil", pizzaDto.getDescription(), "La description doit correspondre");
	        assertThat("margherita.jpg", pizzaDto.getImage(), "L'image doit correspondre");
	        assertEquals(new BigDecimal("10.00"), pizzaDto.getPrice(), "Le prix doit correspondre");
	    }

	    private void assertThat(String string, String name, String string2) {
		// TODO Auto-generated method stub
		
	}

		private void assertThat(Short valueOf, Short id, String string) {
		// TODO Auto-generated method stub
		
	}

		
}
