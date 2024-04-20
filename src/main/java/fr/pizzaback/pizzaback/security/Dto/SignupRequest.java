package fr.pizzaback.pizzaback.security.Dto;



public class SignupRequest {
	

	   private String username;
	    private String password;
	    private String firstname;
	    private String lastname;
	    private String address;

	    public SignupRequest() {
			super();
		}

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	  
	    public String getsetFirstname() {
	
	    	return firstname;}
		

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	
}
