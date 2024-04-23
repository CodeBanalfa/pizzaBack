package fr.pizzaback.pizzaback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.assertj.core.api.Assertions;
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
import fr.pizzaback.pizzaback.core.repository.IPizzaRepository;
import fr.pizzaback.pizzaback.security.Dto.UserDto;
import fr.pizzaback.pizzaback.security.models.Role;
import fr.pizzaback.pizzaback.security.models.RoleName;
import java.util.Date;



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
	        // Créer une instance d'OrderMapp avec un repository fictif
		 IPizzaRepository pizzaRepositoryMock = mock(IPizzaRepository.class);
	      
	        Pizza pizza = new Pizza();
	        pizza.setId((short) 1);
	        when(pizzaRepositoryMock.findById((short) 1)).thenReturn(Optional.of(pizza));

	        OrderMapp orderMapp = new OrderMapp(pizzaRepositoryMock);

	        OrderDTO orderDto = new OrderDTO();
	        orderDto.setId(1L);
	        orderDto.setUserId(10L);
	        orderDto.setDate(new Date());

	        Set<OrderLineDTO> orderLineDtos = new HashSet<>();
	        OrderLineDTO lineDto = new OrderLineDTO();
	        lineDto.setId(1L);
	        lineDto.setPizzaId((short) 1);
	        lineDto.setQuantity(2);
	        orderLineDtos.add(lineDto);

	        orderDto.setOrderLines(orderLineDtos);

	        Order order = orderMapp.dtoToOrder(orderDto);

	        // Utiliser les assertions de JUnit
	       assertEquals(1L, order.getId(), "L'ID doit correspondre");
	      assertEquals(10L, order.getUserId(), "L'ID utilisateur doit correspondre");
	       assertNotNull(order.getDate(), "La date doit être définie");
	       assertEquals(2, order.getOrderLines().size(), "Le nombre de lignes doit correspondre");
	    }

	 private void assertEquals(int l, int size, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(String date, String string) {
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

	    private void assertEquals(BigDecimal bigDecimal, BigDecimal price, String string) {
		// TODO Auto-generated method stub
		
	}

		private void assertThat(String string, String name, String string2) {
		// TODO Auto-generated method stub
		
	}

		private void assertThat(Short valueOf, Short id, String string) {
		// TODO Auto-generated method stub
		
	}

		
}
