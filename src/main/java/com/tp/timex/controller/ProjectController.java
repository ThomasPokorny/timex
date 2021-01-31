package com.tp.timex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tp.timex.factory.MockUsers;
import com.tp.timex.persitence.ProjectRepository;
import com.tp.timex.persitence.documents.Project;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProjectController {

	@Autowired ProjectRepository repository;
	
	@CrossOrigin()
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/project")
	public Mono<Project> createActivity(@RequestBody Project project, @RequestHeader("Authorization") String token) {
		
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		
		Mono<Project> saved = repository.save(project);
		return saved;
	}
	
	@CrossOrigin()
	@PutMapping("/project")
	public Mono<Project> updateActivity(@RequestBody Project project, @RequestHeader("Authorization") String token) {
		
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		
		Mono<Project> saved = repository.save(project);
		return saved;
	}
	
	@CrossOrigin()
	@GetMapping("/project")
	public Flux<Project> getActivities(@RequestHeader("Authorization") String token) {
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		return repository.findAll();
	}
	
	@CrossOrigin()
	@DeleteMapping("/project")
	public Mono<Void> delete(@RequestParam String id, @RequestHeader("Authorization") String token) {
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		return repository.deleteById(id);
	}
}
