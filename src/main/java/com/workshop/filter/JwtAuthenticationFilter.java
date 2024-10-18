package com.workshop.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.workshop.entity.WorkShopUser;
import com.workshop.service.JwtHelper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private JwtHelper jwtHelper;
	
	public JwtAuthenticationFilter(JwtHelper jwtHelper) {
		this.jwtHelper = jwtHelper;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		Authentication authentication;
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(header!=null && header.toLowerCase().contains("bearer")) {
			System.out.println("header authorization found");
			String token = header.split(" ")[1];
			System.out.println("token=>"+token);
			try {
				WorkShopUser user = jwtHelper.decryptToken(token);
				if(user!=null) {
					System.out.println("customer retrieved from token is ok=>");
					authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),null,List.of(new SimpleGrantedAuthority(user.getRole())));
					SecurityContextHolder.getContext().setAuthentication(authentication);
					request.setAttribute("customer-id", user.getId());
					System.out.println("authenticated succefully");
				}
			} catch (Exception e) {
			System.out.println("error when verifying the token =>"+e.getMessage());
			}
		
		}
		filterChain.doFilter(request, response);
		
	}

	
	
}
