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
import com.tp.timex.persitence.StempActivityRepository;
import com.tp.timex.persitence.documents.StempActivity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ActivityStempController {

	@Autowired StempActivityRepository repository;
	
	@CrossOrigin()
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/stemp")
	public Mono<StempActivity> createActivity(@RequestBody StempActivity activity, @RequestHeader("Authorization") String token) {
		
		String userId = MockUsers.getUser(token);
		if(userId == null) {
			throw new HttpUnauthorizedException();
		}
		
		activity.setUserId(userId);
		Mono<StempActivity> saved = repository.save(activity);
		return saved;
	}
	
	@CrossOrigin()
	@PutMapping("/stemp")
	public Mono<StempActivity> updateActivity(@RequestBody StempActivity activity, @RequestHeader("Authorization") String token) {
		String userId = MockUsers.getUser(token);
		if(userId == null) {
			throw new HttpUnauthorizedException();
		}
		
		activity.setUserId(userId);
		Mono<StempActivity> saved = repository.save(activity);
		return saved;
	}
	
	@CrossOrigin()
	@GetMapping("/stemp")
	public Flux<StempActivity> getActivities(@RequestHeader("Authorization") String token, @RequestParam(required=false) String id, @RequestParam(required=false) String from, @RequestParam(required=false) String to, @RequestParam(required=false) String userId) {
		
//		if(id != null) {
//			return repository.findById(id).map(A::getList1).flatMapMany(Flux::fromIterable);
//		}
		
		if(userId != null) {
			return repository.findAllByUserId(userId);
		}

		return repository.findAll();
	}
	
	@CrossOrigin()
	@DeleteMapping("/stemp")
	public Mono<Void> delete(@RequestHeader("Authorization") String token,@RequestParam String id) {
		return repository.deleteById(id);
	}
}
