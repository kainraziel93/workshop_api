package com.workshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.entity.WorkShopUser;

public interface UserRepo  extends JpaRepository<WorkShopUser, Integer>{

	public WorkShopUser findUserByEmail(String email);
}
