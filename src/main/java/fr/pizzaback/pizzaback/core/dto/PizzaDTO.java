package fr.pizzaback.pizzaback.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PizzaDTO {
 
	private Short id;
	private String name;
    private String description;
    private String image;
    private BigDecimal price;
   
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
	
    @Override
 	public String toString() {
 		return "PizzaDTO [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
 				+ ", price=" + price + "]";
 	}
    
}
