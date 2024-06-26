package fr.pizzaback.pizzaback.security.models;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username")})
		
public class User {
	/** technical id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/** username aka login. */
	@NonNull
	@Column(name="phonenumber")
	private String username = "...";

	/** email. */
	
	

	/** password. */
	@NonNull
	private String password = "...";

	/** firstname. */
	@NonNull
	private String firstname = "...";

	/** lastname. */
	@NonNull
	private String lastname = "...";

	/** profile picture. */
    /** Adress **/
	@NonNull
	@Column(name="address")
	private String adress = "...";


	/** roles of the user. */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	/**
	 * Default constructor.
	 */
	public User() {
	}

	/**
	 * Construct a new User.
	 *
	 * @param pUsername the username
	 * @param pPassword the password
	 */
	public User(final String pUsername, final String pPassword) {
		this.username = pUsername;

		this.password = pPassword;
	}

	
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	
	 
	

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @return the name of the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param pEmail the email to set*/
	 
	
	/**
	 * @param pFirstname the firstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
	}

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * @param pPicture the picture to set
	 
	public void setPicture(final Blob pPicture) {
		this.picture = pPicture;
	}*/

	/**
	 * @param pRoles the roles to set
	 */
	public void setRoles(final Set<Role> pRoles) {
		this.roles = pRoles;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

	/**
	 * Définit l'adresse de l'utilisateur.
	 *
	 * @param address l'adresse à définir
	 */
	public void setAddress(final String address) {
	    this.adress = address;
	}

	public void addRole(Set<Role> role) {
		this.roles= role;
		
	}




}
