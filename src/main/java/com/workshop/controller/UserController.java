package com.workshop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.dto.LoginRequest;
import com.workshop.service.UserServices;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserServices userServices;
	@PostMapping
	public ResponseEntity<Map<String,String>> login(@RequestBody LoginRequest loginRequest)
	{
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		return ResponseEntity.ok(userServices.signIn(email, password));
	}
}
