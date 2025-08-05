package com.gms.mapper;

import com.gms.dto.GroceryDto;
import com.gms.entity.GroceryItem;

public class GroceryMapper {
	public static GroceryItem toEntity(GroceryDto dto) {
		GroceryItem item=new GroceryItem();
		item.setName(dto.getName());
		item.setPrice(dto.getPrice());
		item.setQuantity(dto.getQuantity());
		return item;
	}
	
	
	public static GroceryDto toDto(GroceryItem item) {
		GroceryDto dto=new GroceryDto();
		dto.setName(item.getName());
		dto.setPrice(item.getPrice());
		dto.setQuantity(item.getQuantity());
		return dto;
	}

}
