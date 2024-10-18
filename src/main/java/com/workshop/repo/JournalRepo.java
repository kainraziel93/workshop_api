package com.workshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.entity.Journal;
import com.workshop.entity.WorkShopUser;

public interface JournalRepo extends JpaRepository<Journal, Integer> {

	public List<Journal> findJournalByUser(WorkShopUser user);
}
