package fr.pizzaback.pizzaback.core.dto;

public class OrderLineDTO {
  
	private Long id;
    private Short pizzaId; 
    private int quantity;
      public OrderLineDTO() {
		super();

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Short getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Short pizzaId) {
		this.pizzaId = pizzaId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

   
	
}
