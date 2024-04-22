package fr.pizzaback.pizzaback.core.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDTO {
	private Long id;
    private Long userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'.'HH:mm:ss")
    private String date; 
    
    private BigDecimal totalAmount;
    private Set<OrderLineDTO> orderLines;

    // Constructor, getters, and setters
    public OrderDTO() {
        this.date = LocalDateTime.now().toString(); // Default to current date
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<OrderLineDTO> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLineDTO> orderLines) {
        this.orderLines = orderLines;
    }

	public void setDate(Date date2) {
		// TODO Auto-generated method stub
		
	}
}

