package com.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.client.model.Content;
import com.client.model.Entry;
import com.client.model.Result;
import com.client.repository.EntryRepo;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private EntryRepo entryRepo;
	
	@GetMapping("/category:{cat}")
	public ResponseEntity<List<Content>> getContent(@PathVariable String cat){
		String url = "https://api.publicapis.org/entries";
		RestTemplate rt = new RestTemplate();
		
		Result res = rt.getForObject(url, Result.class);
		
		List<Entry> entries = res.getEntries();
		
		List<Content> contents=new ArrayList<>();
	
		entries.stream().filter(e->e.getCategory().equalsIgnoreCase(cat)).forEach(e->contents.add(new Content(e.getAPI(),e.getDescription())));

		return new ResponseEntity<List<Content>>(contents,HttpStatus.OK);
	}
	
	@GetMapping("/entries")
	public ResponseEntity<List<Entry>> getEntries(){
		String url = "https://api.publicapis.org/entries";
		RestTemplate rt = new RestTemplate();
		
		Result res = rt.getForObject(url, Result.class);
		
		List<Entry> entries = res.getEntries();
	
		List<Entry> saved = entryRepo.saveAll(entries);
		
		return new ResponseEntity<List<Entry>>(saved,HttpStatus.OK);
	}
	

	

}
