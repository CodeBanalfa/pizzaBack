package fr.pizzaback.pizzaback.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_line")
public class OrderLine {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "quantity")
	    private int quantity;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "ord_id", nullable = false)
	    private Order order;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "piz_id", nullable = false)
	    private Pizza pizza;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public Order getOrder() {
	        return order;
	    }

	    public void setOrder(Order order) {
	        this.order = order;
	    }

	    public Pizza getPizza() {
	        return pizza;
	    }

	    public void setPizza(Pizza pizza) {
	        this.pizza = pizza;
	    }
}
