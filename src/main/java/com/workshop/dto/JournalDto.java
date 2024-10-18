package com.workshop.dto;

import com.workshop.entity.Journal;

public class JournalDto {

	private Journal journal;
	private int userId;
	
	
	public JournalDto() {

	}


	public JournalDto(Journal journal, int userId) {
		super();
		this.journal = journal;
		this.userId = userId;
	}


	public Journal getJournal() {
		return journal;
	}


	public void setJournal(Journal journal) {
		this.journal = journal;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "JournalDto [journal=" + journal + ", userId=" + userId + "]";
	}
	
	
	
	
}
