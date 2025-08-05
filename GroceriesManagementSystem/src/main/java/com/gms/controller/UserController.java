package com.gms.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gms.dto.CartItemDto;
import com.gms.dto.GroceryDto;
import com.gms.entity.GroceryItem;
import com.gms.mapper.GroceryMapper;
import com.gms.repository.GroceryRepository;
import com.gms.service.CartItemService;
import com.gms.service.GroceryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {
	@Autowired
	private GroceryService service;
	
	@Autowired
	private CartItemService cservice;
	
	@GetMapping("/groceries")
	public ResponseEntity<List<GroceryDto>> getGroceries(){
		return ResponseEntity.ok(service.showGroceryList());
	}
	
	@PostMapping("/addToCart")
	public ResponseEntity<String> addToCart(@RequestBody @Valid CartItemDto dto,Principal principal){
		cservice.pushToCart(dto,principal.getName());
		return ResponseEntity.ok("Item added successfully");
	}
	
	
	@GetMapping("/view")
	public ResponseEntity<List<CartItemDto>> viewCart(Principal principal){
		return ResponseEntity.ok(cservice.viewcart(principal.getName()));
	}
	


}
