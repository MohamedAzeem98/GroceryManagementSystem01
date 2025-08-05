package com.gms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gms.entity.CartItem;
import com.gms.entity.User;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
	List<CartItem> findByUser(User user);
}
