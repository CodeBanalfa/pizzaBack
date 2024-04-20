package fr.pizzaback.pizzaback.security.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.ObjectName;
import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.pizzaback.pizzaback.security.Dto.JwtResponse;
import fr.pizzaback.pizzaback.security.Dto.LoginRequest;
import fr.pizzaback.pizzaback.security.Dto.SignupRequest;
import fr.pizzaback.pizzaback.security.Dto.TokenRefreshRequest;
import fr.pizzaback.pizzaback.security.Dto.TokenRefreshResponse;
import fr.pizzaback.pizzaback.security.Dto.UserDto;
import fr.pizzaback.pizzaback.security.jwt.JwtProvider;
import fr.pizzaback.pizzaback.security.jwt.exception.TokenRefreshException;
import fr.pizzaback.pizzaback.security.models.RefreshToken;
import fr.pizzaback.pizzaback.security.models.RoleName;
import fr.pizzaback.pizzaback.security.models.User;
import fr.pizzaback.pizzaback.security.service.IRefreshTokenService;
import fr.pizzaback.pizzaback.security.service.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.lang.Collections;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 * Classe permettant de gérer la sécurité.
 *
 * @author piot
 *
 */

@RestController
@RequestMapping("/auth")
public final class AuthController {

	private static final List<ObjectName> User = null;
	/** token header to use in JWT. */
	@Value("${app.jwtTokenHeader}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	/** import jwtprovider. */
	@Autowired
	private JwtProvider tokenProvider;

	/** import refreshToken service. */
	@Autowired
	private IRefreshTokenService refreshTokenService;

	/** import user service. */
	@Autowired
	private UserDetailsServiceImpl userService;

	/**
	 *
	 * @param request a login + password couple
	 * @return a response with the jwt
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody final LoginRequest request) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(request.getUsername());

		User user = userService.loadUserDetails(request.getUsername());

		refreshTokenService.deleteExpired();
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());

		return ResponseEntity.ok(new JwtResponse(tokenHeader + " " + jwt, tokenProvider.getExpiryDate(jwt),
				new UserDto(user), refreshToken.getToken()));
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		// Vérifiez si le nom d'utilisateur est déjà pris
		if (userService.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body("Error: Username is already taken!");
		}

		// Encodez le mot de passe avec BCrypt
		String encodedPassword = new BCryptPasswordEncoder().encode(signUpRequest.getPassword());

		// Créez un nouvel utilisateur avec les informations fournies
		User user = new User();
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(encodedPassword);
		user.setFirstname(signUpRequest.getsetFirstname());
		user.setLastname(signUpRequest.getLastname());
		user.setAddress(signUpRequest.getAddress());

		// Sauvegardez les détails de l'utilisateur
		userService.save(user);

  

		// Générez le token JWT
		String jwt = tokenProvider.generateToken(signUpRequest.getUsername());

		// Créez le refresh token
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());

		// Retournez la réponse avec le token JWT et le refresh token
		return ResponseEntity
				.ok(new JwtResponse(jwt, tokenProvider.getExpiryDate(jwt), new UserDto(user), refreshToken.getToken()));
	}


	/**
	 * Get a new token.
	 *
	 * @param request a valid refresh token
	 * @return a new token
	 */
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@Valid @RequestBody final TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken).map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser).map(user -> {
					String jwt = tokenProvider.generateToken(user.getUsername());
					RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());
					return ResponseEntity.ok(new TokenRefreshResponse(tokenHeader + " " + jwt,
							tokenProvider.getExpiryDate(jwt), refreshToken.getToken()));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}

	/**
	 *
	 * @param username a username
	 * @return the profile picture of the user
	 * @throws SQLException
	 
	@GetMapping(value = "/picture/{username}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<InputStreamResource> getPicture(@PathVariable("username") final String username)
			throws SQLException {
		User user = userService.loadUserDetails(username);

		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
				.body(new InputStreamResource(user.getPicture().getBinaryStream()));
	}*/

	/**
	 *
	 * @param userDto a userDto containing at least a username and a list of
	 *                settings
	 * @param request the http request
	 * @return the updated user
	 */
	@PostMapping(value = "/updateSettings")
	public UserDto updateSettings(final @RequestBody UserDto userDto, final HttpServletRequest request) {
		User user = userService.loadUserDetails(userDto.getUsername());

		return new UserDto(userService.update(user));

	}
}