package fr.pizzaback.pizzaback.security.Dto;

import fr.pizzaback.pizzaback.security.models.User;

/**
 * This class represents the details of a user.
 */
public class UserDto {

	/** the login. */
	private String username;

	/** the firstname. */
	private String firstname;

	/** the lastname. */
	private String lastname;

	/** the role of te user. */
	private String role;



	/** Default constructor. */
	public UserDto() {
		super();
	}

	/**
	 * Create a new UserDto from a User.
	 *
	 * @param pUser the user to use
	 */
	public UserDto(final User pUser) {
		this.username = pUser.getUsername();
		this.firstname = pUser.getFirstname();
		this.lastname = pUser.getLastname();
		 if (!pUser.getRoles().isEmpty()) {
		        this.role = pUser.getRoles().iterator().next().getName().name();
		    } else {
		        this.role = "No Role"; // Ou tout autre valeur par dÃ©faut
		    }


	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the hasPicture
	 */
	

	/**
	 * @param pFirstname the firstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @param pHasPicture the hasPicture to set
	 */
	

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @param pRole the role to set
	 */
	public void setRole(final String pRole) {
		this.role = pRole;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

}