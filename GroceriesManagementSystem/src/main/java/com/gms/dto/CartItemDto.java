package com.gms.dto;

import jakarta.validation.constraints.Positive;

public class CartItemDto {
	private Long groceryItemId;
	
	@Positive
	private Integer quantity;

	public Long getGroceryItemId() {
		return groceryItemId;
	}

	public void setGroceryItemId(Long groceryItemId) {
		this.groceryItemId = groceryItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
