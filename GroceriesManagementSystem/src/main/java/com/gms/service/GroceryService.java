package com.gms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.dto.GroceryDto;
import com.gms.entity.GroceryItem;
import com.gms.exceptions.ResourceNotFoundException;
import com.gms.mapper.GroceryMapper;
import com.gms.repository.GroceryRepository;

import jakarta.validation.Valid;

@Service
public class GroceryService {
	@Autowired 
	private GroceryRepository groceryRepo;

	public GroceryDto postGrocery(@Valid GroceryDto dto) {
		GroceryItem item=GroceryMapper.toEntity(dto);
		GroceryItem saved=groceryRepo.save(item);
		return GroceryMapper.toDto(saved);
	}

	public GroceryDto modifyGrocery(Long id, @Valid GroceryDto dto) {
		GroceryItem item=groceryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Grocery not found : "+id));
		item.setName(dto.getName());
		item.setPrice(dto.getPrice());
		item.setQuantity(dto.getQuantity());
		GroceryItem updated=groceryRepo.save(item);
		return GroceryMapper.toDto(updated);
	}

	public List<GroceryDto> showGroceryList() {
		List<GroceryItem> items=groceryRepo.findAll();
		List<GroceryDto> dtos=items.stream().map(GroceryMapper::toDto).toList();
		return dtos;
	}
	
	

}
