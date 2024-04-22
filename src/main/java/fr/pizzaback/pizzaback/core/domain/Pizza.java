package fr.pizzaback.pizzaback.core.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name ="pizza")
public class Pizza {
 
	
	@Id
	@Column(name = "id")
    private Short id;

	@Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "price")
    private BigDecimal price;
public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
    public Short getId() {
		return id;
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


	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	   @Override
		public String toString() {
			return "Pizza [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", price="
					+ price + "]";
		}
	public void setImage(String string) {
		this.image=getImage();
		
	}
	public void setId(Short pizzaId) {
		this.id=id;
		
	}
	


	




}





    // Getters and setters
    // toString

