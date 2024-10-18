package com.workshop.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workshop.entity.WorkShopUser;
import com.workshop.repo.UserRepo;

@Service
public class UserServices {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private JwtHelper jwtHelper;
	
	public WorkShopUser signUp(WorkShopUser user) {
		try {
			WorkShopUser userExist = userRepo.findUserByEmail(user.getEmail());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRole(
					user.getRole()==null?
					"USER"
					:user.getRole()
					);
			return userExist == null? userRepo.save(user) : null;
		} catch (Exception e) {
			System.out.println("erreur on error service "+e.getMessage());
			
		}
		return null;
	}
	
	public Map<String,String> signIn(String email,String password) {
		try {
			WorkShopUser userExist = userRepo.findUserByEmail(email);
			if(passwordEncoder.matches(password, userExist.getPassword())) {
				String token = jwtHelper.createToken(userExist);
				String role = userExist.getRole();
				return Map.of("token",token,"role",role,"user_id",userExist.getId()+"");
			}
			

		} catch (Exception e) {
			System.out.println("erreur in signIn method =>"+e.getMessage());
		}
		return null;
	}
}
