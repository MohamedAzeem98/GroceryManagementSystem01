package com.gms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gms.dto.GroceryDto;
import com.gms.dto.LoginDto;
import com.gms.security.AuthController;
import com.gms.service.GroceryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
	@Autowired 
	private GroceryService service;
	
	
	
	@PostMapping("/grocery")
	public ResponseEntity<GroceryDto> addGrocery(@RequestBody @Valid GroceryDto dto){
		
		return ResponseEntity.ok(service.postGrocery(dto));
	}
	
	@PutMapping("/grocery/{id}")
	public ResponseEntity<GroceryDto> updateGrocery(@PathVariable Long id,@RequestBody @Valid GroceryDto dto){
		
		return ResponseEntity.ok(service.modifyGrocery(id,dto));
	}

	
	
}
