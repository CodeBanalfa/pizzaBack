/**
 * 
 */
package fr.pizzaback.pizzaback.core.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name ="pizza")
public class Pizza {
	 

	@Id
	 
		@Column(name = "name")
	    private String name;
	    
	    @Column(name = "description")
	    private String description;
	    
	    @Column(name = "image")
	    private String image;
	    
	    @Column(name = "price")
	    private BigDecimal price;
	    
   private Short id;
	    
	    public Pizza() {
		super();
		
	}
	
	    // Getters and setters
	    public Short getId() {
	        return id;
	    }

	    public void setId(Short id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getImage() {
	        return image;
	    }

	    public void setImage(String image) {
	        this.image = image;
	    }

	    public BigDecimal getPrice() {
	        return price;
	    }

	    public void setPrice(BigDecimal price) {
	        this.price = price;
	    }
	    //toString
	     @Override
		     public String toString() {
			return "Pizza [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", price="
					+ price + "]";
		       }
	}
	
	


