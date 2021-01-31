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
import com.tp.timex.persitence.TaskRepository;
import com.tp.timex.persitence.documents.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TaskController {

	@Autowired TaskRepository repository;
	
	@CrossOrigin()
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/task")
	public Mono<Task> createActivity(@RequestBody Task task, @RequestHeader("Authorization") String token) {
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		Mono<Task> saved = repository.save(task);
		return saved;
	}
	
	@CrossOrigin()
	@PutMapping("/task")
	public Mono<Task> updateActivity(@RequestBody Task task, @RequestHeader("Authorization") String token) {
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		Mono<Task> saved = repository.save(task);
		return saved;
	}
	
	@CrossOrigin()
	@GetMapping("/task")
	public Flux<Task> getActivities(@RequestHeader("Authorization") String token) {
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		return repository.findAll();
	}
	
	@CrossOrigin()
	@DeleteMapping("/task")
	public Mono<Void> delete(@RequestParam String id, @RequestHeader("Authorization") String token) {
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		return repository.deleteById(id);
	}
	
}
