package com.gms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gms.dto.LoginDto;
import com.gms.dto.UserDto;
import com.gms.entity.User;
import com.gms.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> register( @RequestBody @Valid UserDto dto){
		User user=new User();
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(encoder.encode(dto.getPassword()));
		user.setRole(dto.getRole());
		userRepo.save(user);
		return ResponseEntity.ok("Registered");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody @Valid LoginDto dto){
		User user=userRepo.findByEmail(dto.getEmail())
				.orElseThrow(()-> new RuntimeException("Invalid credentials"));
				
	
		if(encoder.matches(dto.getPassword(),user.getPassword())) {
			String token=jwtUtil.generateToken(user.getEmail());
			return ResponseEntity.ok(token);
		}else {
			throw new RuntimeException("Invalid credentials");
		}
	
	}
	
	// For Admin
	
	@PostMapping("/register/admin")
	public ResponseEntity<String> registerAdmin(@RequestBody @Valid UserDto dto) {
	    User user = new User();
	    user.setUsername(dto.getUsername());
	    user.setEmail(dto.getEmail());
	    user.setPassword(encoder.encode(dto.getPassword()));
	    user.setRole("ADMIN");
	    userRepo.save(user);
	    return ResponseEntity.ok("Admin registered");
	}
	
}
