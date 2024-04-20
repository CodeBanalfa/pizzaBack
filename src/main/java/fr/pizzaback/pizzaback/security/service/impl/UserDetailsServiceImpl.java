package fr.pizzaback.pizzaback.security.service.impl;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzaback.pizzaback.security.Dto.SignupRequest;
import fr.pizzaback.pizzaback.security.jwt.JwtProvider;
import fr.pizzaback.pizzaback.security.models.User;
import fr.pizzaback.pizzaback.security.repository.UserRepository;
import fr.pizzaback.pizzaback.security.service.IRefreshTokenService;
import fr.pizzaback.pizzaback.security.utils.UserMapper;
import fr.pizzaback.pizzaback.security.utils.UserPrincipal;
import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class UserDetailsServiceImpl<RegisterRequest> implements UserDetailsService {
	/** import the userRepository. */
	@Autowired
	private UserRepository userRepository;
	 @Autowired
	    private JwtProvider tokenProvider;
	 @Autowired
	    private IRefreshTokenService refreshTokenService;
	 
	/**
	 * Load user's details from the DB.
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return UserMapper.userToPrincipal(user);
	}

	/**
	 *
	 * @param username a username
	 * @return the detail of the given user
	 * @throws UsernameNotFoundException
	 */
	public User loadUserDetails(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return user;
	}

	/**
	 * Update or create a user.
	 *
	 * @param user a user to save
	 * @return the updated user
	 */
	public User update(final User user) {

		return userRepository.save(user);
	}
	public boolean existsByUsername(String username) {
	    return userRepository.existsByUsername(username);


	}



	

	public void save(User user) {
		userRepository.save(user);
		
	}

     
}
	

