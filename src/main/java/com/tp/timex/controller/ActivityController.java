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
import com.tp.timex.persitence.ActivityRepository;
import com.tp.timex.persitence.documents.Activity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ActivityController {

	@Autowired ActivityRepository repository;
	
	@CrossOrigin()
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/activity")
	public Mono<Activity> createActivity(@RequestBody Activity activity, @RequestHeader("Authorization") String token) {
		
		String userId = MockUsers.getUser(token);
		if(userId == null) {
			throw new HttpUnauthorizedException();
		}
		
		activity.setUserId(userId);
		Mono<Activity> saved = repository.save(activity); 
		return saved;
	}
	
	@CrossOrigin()
	@PutMapping("/activity")
	public Mono<Activity> updateActivity(@RequestBody Activity activity, @RequestHeader("Authorization") String token) {
		
		String userId = MockUsers.getUser(token);
		if(userId == null) {
			throw new HttpUnauthorizedException();
		}
		
		activity.setUserId(userId);
		Mono<Activity> saved = repository.save(activity);
		return saved;
	}
	
	@CrossOrigin()
	@GetMapping("/activity")
	public Flux<Activity> getActivities(@RequestHeader("Authorization") String token, @RequestParam(required=false) String id, @RequestParam(required=false) String from, @RequestParam(required=false) String to, @RequestParam(required=false) String userId) {
		
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		
//		if(id != null) {
//			return repository.findById(id).map(A::getList1).flatMapMany(Flux::fromIterable);
//		}
		
		if(userId != null) {
			return repository.findAllByUserId(userId);
		}

		return repository.findAll();
	}
	
	@CrossOrigin()
	@DeleteMapping("/activity")
	public Mono<Void> delete(@RequestParam String id, @RequestHeader("Authorization") String token) {
		return repository.deleteById(id);
	}
	
}
