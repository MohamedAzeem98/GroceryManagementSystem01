package com.gms.mapper;

import com.gms.dto.CartItemDto;
import com.gms.entity.CartItem;
import com.gms.entity.GroceryItem;
import com.gms.entity.User;

public class CartMapper {
	public static CartItemDto toDto(CartItem cartItem) {
        CartItemDto dto = new CartItemDto();
        dto.setGroceryItemId(cartItem.getGroceryItem().getId());
        dto.setQuantity(cartItem.getQuantity());
        return dto;
    }
	public static CartItem toEntity(CartItemDto dto, User user, GroceryItem item) {
		CartItem cartItem = new CartItem();
		cartItem.setUser(user);
		cartItem.setGroceryItem(item);
		cartItem.setQuantity(dto.getQuantity());
		return cartItem;
	}
}
