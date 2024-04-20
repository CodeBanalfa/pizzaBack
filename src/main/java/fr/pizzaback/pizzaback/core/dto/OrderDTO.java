package fr.pizzaback.pizzaback.core.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO {
	 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	private Long id;
	    private Long userId;
	    private LocalDateTime date;
	    private BigDecimal totalAmount;

}
