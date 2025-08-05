package com.gms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gms.entity.GroceryItem;

public interface GroceryRepository extends JpaRepository<GroceryItem,Long>{

}
