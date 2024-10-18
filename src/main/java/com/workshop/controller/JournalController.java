package com.workshop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.dto.JournalDto;
import com.workshop.entity.Journal;
import com.workshop.service.JournalServices;

@RestController
@RequestMapping("journal")
public class JournalController {

	@Autowired
	private JournalServices journalServices;
	
	@PostMapping
	public ResponseEntity<Journal> addJournal(@RequestBody JournalDto journalDto){
		return ResponseEntity.ok(journalServices.addJournalRepo(journalDto));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Journal>> getJournals(){
		return ResponseEntity.ok(this.journalServices.getJorunals());
	}
	
	@GetMapping("user/{id}")
	public ResponseEntity<List<Journal>> getJournalsByUser(@PathVariable int id){
		System.out.println("access successful "+id);
		return ResponseEntity.ok(this.journalServices.getJournalByUserId(id));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Journal> getJournal(@PathVariable int id){
		return ResponseEntity.ok(this.journalServices.getJournalById(id));
	}
	
	@GetMapping("status/{id}")
	public ResponseEntity<Map<String,String>> changeJournalStatus(@PathVariable int id,@RequestParam String status){
		return ResponseEntity.ok(journalServices.changeJournalStatus(id,status));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Journal> updateJournal(@PathVariable int id, JournalDto journal){
		return ResponseEntity.ok(journalServices.updateJournal(id, journal));
	}
}
