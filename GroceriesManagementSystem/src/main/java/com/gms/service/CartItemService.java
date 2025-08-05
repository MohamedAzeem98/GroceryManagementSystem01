package com.gms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.dto.CartItemDto;
import com.gms.entity.CartItem;
import com.gms.entity.GroceryItem;
import com.gms.entity.User;
import com.gms.exceptions.ResourceNotFoundException;
import com.gms.mapper.CartMapper;
import com.gms.repository.CartItemRepository;
import com.gms.repository.GroceryRepository;
import com.gms.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class CartItemService {
	@Autowired 
	private CartItemRepository crepo;
	
	@Autowired
	private GroceryRepository grepo;
	
	@Autowired
	private UserRepository urepo;

	public void pushToCart(CartItemDto dto,String email) {
		User user=urepo.findByEmail(email)
				.orElseThrow(()->new ResourceNotFoundException("user not found"));
		
		GroceryItem item=grepo.findById(dto.getGroceryItemId())
				.orElseThrow(()-> new ResourceNotFoundException("Grocery not found"));
		
		CartItem cart=CartMapper.toEntity(dto,user,item);
		crepo.save(cart);
		
	}

	public List<CartItemDto> viewcart(String name) {
		User user=urepo.findByEmail(name)
				.orElseThrow(()-> new ResourceNotFoundException("user not found"));
		
		List<CartItem> items=crepo.findByUser(user);
		return items.stream()
				.map(CartMapper::toDto)
				.toList();
	}
	
	
	

	

}
