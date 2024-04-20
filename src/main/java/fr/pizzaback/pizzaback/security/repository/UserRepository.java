package fr.pizzaback.pizzaback.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pizzaback.pizzaback.security.models.Role;
import fr.pizzaback.pizzaback.security.models.RoleName;
import fr.pizzaback.pizzaback.security.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * find a user from its login.
	 *
	 * @param username the login
	 * @return an optional user if found
	 */
	Optional<User> findByUsername(String username);

	boolean existsByUsername(String username);
	  



}
