package com.workshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.dto.JournalDto;
import com.workshop.entity.Journal;
import com.workshop.entity.WorkShopUser;
import com.workshop.repo.JournalRepo;
import com.workshop.repo.UserRepo;

@Service
public class JournalServices{

	@Autowired
	private JournalRepo journalRepo;
	@Autowired
	private UserRepo userRepo;
	
	public JournalServices() {
		
	}
	
	public Journal addJournalRepo(JournalDto journal) {
		try {
			Journal journalToAdd = journalMapper(journal);
			Journal journalSaved = journalRepo.save(journalToAdd);
			return journalSaved;
			
		} catch (Exception e) {
			System.out.println("erreur "+e.getMessage());
			return null;
		}
	}
	
	public void supprimerJournal(int journalId) {
		try {
			 journalRepo.delete(null);
		} catch (Exception e) {
			System.out.println("erreur "+e.getMessage());
		}
		
	}
	
	public Journal updateJournal(int journalId,JournalDto journalDto) {
		try {
			Journal journal = journalRepo.findById(journalId).get();
			Journal journalMapper = journalMapper(journalDto);
			modifyJournal(journalMapper, journal);
			return journal;
			 
			
		} catch (Exception e) {
			System.out.println("erreur "+e.getMessage());
			return null;
		}
	}
	
	public List<Journal> getJournalByUserId(int id){
		WorkShopUser user = this.userRepo.findById(id).get();
		List<Journal> journalList = this.journalRepo.findJournalByUser(user);
		return journalList;
	}
	public Journal getJournalById(int id){
		
		Journal journal = this.journalRepo.findById(id).get();
		return journal;
	}
	public List<Journal> getJorunals(){
		return this.journalRepo.findAll();
	}
	
	public void modifyJournal(Journal journal,Journal journalToUpdate) {
		journalToUpdate.setDescription(journal.getDescription() == null || journal.getDescription().isEmpty() 
				? journalToUpdate.getDescription() 
						: journal.getDescription()
						);
		
		journalToUpdate.setScreenshots(journal.getScreenshots()==null 
				?journalToUpdate.getScreenshots() 
						: journal.getScreenshots()
						);
		
		journalToUpdate.setUserUrl(journal.getUserUrl() == null || journal.getUserUrl().isEmpty()  
				? journalToUpdate.getUserUrl() 
						: journal.getUserUrl()
							);
		
	}
	
	public Map<String,String> changeJournalStatus(int id,String status){
		try {
			Journal journal = this.journalRepo.findById(id).get();
			if(!journal.getStatus().equals("en-cours")) return Map.of("message","cannot change Status of a journal that don t have the en-cours status");
			journal.setStatus(status);
			this.journalRepo.save(journal);
			return Map.of("message","journal updated successfully ");
		} catch (Exception e) {
			System.out.println("error =>"+e.getMessage());
			return Map.of("message","something went wrong with the changeJournalStatus");
		}
		
	}
	
	public Journal journalMapper(JournalDto journalDto) {
		WorkShopUser user = userRepo.findById(journalDto.getUserId()).get();
		Journal journal = new Journal();
		journal.setDescription(journalDto.getJournal().getDescription());
		journal.setScreenshots(journalDto.getJournal().getScreenshots());
		journal.setTitle(journalDto.getJournal().getTitle());
		journal.setStatus(journalDto.getJournal().getStatus());
		journal.setReseau(journalDto.getJournal().getReseau());
		journal.setUserUrl(journalDto.getJournal().getUserUrl());
		journal.setUser(user);
		return journal;
	}
	
	
}
