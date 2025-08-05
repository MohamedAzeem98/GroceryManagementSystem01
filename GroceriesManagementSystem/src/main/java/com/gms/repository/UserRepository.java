package com.gms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gms.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	Optional<User> findByEmail(String email);
}
